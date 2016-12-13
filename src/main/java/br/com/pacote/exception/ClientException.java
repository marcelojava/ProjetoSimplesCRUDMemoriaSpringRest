package br.com.pacote.exception;

public abstract class ClientException extends RuntimeException {

	public abstract int getStatusCode();

	public ClientException(String message) {
		super(message);
	}

}
