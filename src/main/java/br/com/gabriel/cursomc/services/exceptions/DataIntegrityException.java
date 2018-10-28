package br.com.gabriel.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	/**
	 * Esse Throwable exceção de algo que ocorreu antes da então exceção.
	 */
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
