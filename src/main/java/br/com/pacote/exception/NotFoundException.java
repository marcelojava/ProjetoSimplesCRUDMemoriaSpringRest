package br.com.pacote.exception;

public class NotFoundException extends ClientException {

	@Override
	public int getStatusCode() {
		return 404;
	}

	public NotFoundException(String message) {
		super(message);
	}
}
