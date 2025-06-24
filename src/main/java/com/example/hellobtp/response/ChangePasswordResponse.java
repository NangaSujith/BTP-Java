package com.example.hellobtp.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangePasswordResponse {	
	String infoMessage;
	String infoStatus;
	

}
