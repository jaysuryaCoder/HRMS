package com.fdaindia.hrms.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalResponse {
	private String message;
	private Object object;
	private boolean status;

}
