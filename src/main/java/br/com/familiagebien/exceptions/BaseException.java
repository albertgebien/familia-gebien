package br.com.familiagebien.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class BaseException extends Exception {

	public BaseException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
