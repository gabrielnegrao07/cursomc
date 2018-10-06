package br.com.gabriel.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	/**
	 * Esse Throwable exceção de algo que ocorreu antes da então exceção.
	 */
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
