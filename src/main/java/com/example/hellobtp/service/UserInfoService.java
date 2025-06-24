package com.example.hellobtp.service;

import com.example.hellobtp.dto.UserInfoDTO;
import com.example.hellobtp.request.PasswordEditRequest;
import com.example.hellobtp.response.ChangePasswordResponse;
import com.example.hellobtp.response.LoginResponse;

public interface UserInfoService {

    public LoginResponse authenticateUser(String empId, String password);

    UserInfoDTO findByEmpId(String empId);

    ChangePasswordResponse EditPasswordByEmailId(PasswordEditRequest passwordeditRequest) throws Exception;
}
