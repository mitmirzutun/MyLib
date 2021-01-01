package exceptions;

public class InvalidEncryptionKeyLength extends IllegalValueException {
	public InvalidEncryptionKeyLength(String s) {
		super(s);
	}
}
