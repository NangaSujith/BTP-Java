package com.example.hellobtp.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordEditRequest {

	private Long id;
	//private String emailId;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

}
