package com.nim.tools.recontool.generic;

public class ReconToolException extends Exception {
	
	private boolean isFatal;

	public ReconToolException() {
		// TODO Auto-generated constructor stub
	}

	public ReconToolException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReconToolException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ReconToolException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ReconToolException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ReconToolException(boolean isFatalException, String msg) {
		super(msg);
		this.setFatal(isFatalException);
	}

	public boolean isFatal() {
		return isFatal;
	}

	public void setFatal(boolean isFatal) {
		this.isFatal = isFatal;
	}

}
