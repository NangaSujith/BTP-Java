package com.example.hellobtp.controller;

import com.example.hellobtp.dto.UserInfoDTO;
import com.example.hellobtp.request.LoginRequest;
import com.example.hellobtp.request.PasswordEditRequest;
import com.example.hellobtp.response.ChangePasswordResponse;
import com.example.hellobtp.response.LoginResponse;
import com.example.hellobtp.service.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Details API", description = "Operations related to user details")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/authenticate")
    public LoginResponse doAuthenticate(@RequestBody LoginRequest loginData) {
        return userInfoService.authenticateUser(loginData.getEmpId(), loginData.getPassword());

    }

    @RequestMapping(value = "changePassword", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangePasswordResponse changePassword(@Validated @RequestBody PasswordEditRequest passwordeditRequest) throws Exception {
        return userInfoService.EditPasswordByEmailId(passwordeditRequest);

    }

    @RequestMapping(value = "getAllUsersByEmpId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserInfoDTO getAllUsersByEmpId(@RequestParam(required = true) String empId) {
        UserInfoDTO userDataList = null;
        try {
            userDataList = userInfoService.findByEmpId(empId);
        } catch (Exception e) {
            LOGGER.error("Error Occured in getting user details based on empId", e);
        }
        return userDataList;

    }
}
