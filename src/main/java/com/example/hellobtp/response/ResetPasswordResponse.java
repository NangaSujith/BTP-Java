package com.example.hellobtp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResetPasswordResponse {

	String infoMessage;
	String infoStatus;

}
