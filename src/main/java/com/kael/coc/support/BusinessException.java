package com.kael.coc.support;

public class BusinessException extends RuntimeException {

	private int errorCode;

	public BusinessException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public BusinessException() {
		this(ErrorCode.success);
	}

	public BusinessException(int errorCode,String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}

	public BusinessException(int errorCode,String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public BusinessException(int errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessException(int errorCode,Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
	

}
