package com.te.officeSystem.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

	private boolean isError;
	private String message;
	private Object data;
}
