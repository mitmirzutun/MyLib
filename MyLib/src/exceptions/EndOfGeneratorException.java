package exceptions;

public class EndOfGeneratorException extends RuntimeException {
	public EndOfGeneratorException() {
		this("Reached end of Generator");
	}
	public EndOfGeneratorException(String s) {
		
	}
}
