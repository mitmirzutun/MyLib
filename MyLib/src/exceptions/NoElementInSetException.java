package exceptions;

public class NoElementInSetException extends RuntimeException {
	public NoElementInSetException() {
		super("Expected an element in set, found none.");
	}
}
