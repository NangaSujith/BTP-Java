package com.example.hellobtp.serviceimpl;

import com.example.hellobtp.dto.UserInfoDTO;
import com.example.hellobtp.model.UserInfo;
import com.example.hellobtp.repository.UserInfoRepository;
import com.example.hellobtp.request.PasswordEditRequest;
import com.example.hellobtp.response.ChangePasswordResponse;
import com.example.hellobtp.response.LoginResponse;
import com.example.hellobtp.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public LoginResponse authenticateUser(String empId, String password) {
        LoginResponse loginResponse = LoginResponse.builder().infoMessage("").build();
        /// UserInfoDTO dbUserInfo = findByEmail(email);
        UserInfoDTO dbUserInfo = findByEmpId(empId);
        if (dbUserInfo != null) {

            Boolean active = Boolean.FALSE;
            loginResponse.setActive(active);
            loginResponse.setLoginValid(active);

            if (password.equals(dbUserInfo.getPassword())) {
                /// loginResponse.setIsSuperAdmin(clientInfo.getSuperAdmin());
                loginResponse.setActive(Boolean.TRUE);
                loginResponse.setLoginValid(Boolean.TRUE);
                // loginResponse.setResetPwd(dbUserInfo.getResetPwd());
                return loginResponse;

            } else {
                loginResponse.setInfoMessage("");
                return loginResponse;
            }
        } else {
            loginResponse.setInfoMessage("");
            return loginResponse;
        }

    }

    @Override
    public UserInfoDTO findByEmpId(String empId) {
        UserInfoDTO userInfoDTO = null;
        short isDelete = 0;

        UserInfo userInfo = userInfoRepository.findUserInfoByEmpCodeAndIsDelete(empId, isDelete);
        log.error("userDate " + userInfo);
        if (userInfo != null) {
            userInfoDTO = modelMapper.map(userInfo, UserInfoDTO.class);
        }
        return userInfoDTO;
    }

    @Override
    public ChangePasswordResponse EditPasswordByEmailId(@Validated PasswordEditRequest passwordeditRequest)
            throws Exception {
        short notDeleted = 0;
        ChangePasswordResponse responseData = new ChangePasswordResponse();
        String msg = null;
        String error = null;
        Optional<UserInfo> userinfoEntit = userInfoRepository.findById(passwordeditRequest.getId());
        UserInfo userInfo = userInfoRepository.findByIdAndIsDelete(passwordeditRequest.getId(), notDeleted);
        if (userInfo != null && userinfoEntit.isPresent()) {

            UserInfo userPassSave = userinfoEntit.get();

            if ((passwordeditRequest.getOldPassword()).equals(userPassSave.getPassword())) {
                userPassSave.setPassword(passwordeditRequest.getNewPassword());
                userPassSave.setPassword(passwordeditRequest.getConfirmPassword());
                Boolean active = Boolean.FALSE;
                System.out.println(active);
                if (passwordeditRequest.getNewPassword().equals(passwordeditRequest.getConfirmPassword())
                        && !(passwordeditRequest.getNewPassword().equals(passwordeditRequest.getOldPassword()))) {

                    userInfoRepository.save(userPassSave);
                    msg = "Password successfully updated";
                    error = "Success";

                } else {
                    msg = "New Password and confirm password doesn't match or "
                            + "Old PassWord and New Password are same ";
                    error = "Error";
                }
            } else {
                msg = "Current password doesn't match with the existing password ";
                error = "Error";
            }
        } else {
            msg = "User does not exist";
            error = "Error";

        }
        responseData.setInfoMessage(msg);
        responseData.setInfoStatus(error);
        return responseData;
    }

}
