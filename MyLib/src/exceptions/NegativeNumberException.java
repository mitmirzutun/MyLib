package exceptions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NegativeNumberException extends RuntimeException {
	public NegativeNumberException(Double d) {
		this(d.toString());
	}
	public NegativeNumberException(Long l) {
		this(l.toString());
	}
	public NegativeNumberException(BigInteger bi) {
		this(bi.toString());
	}
	public NegativeNumberException(BigDecimal bd) {
		this(bd.toString());
	}
	public NegativeNumberException(String s) {
		super("Expected positive number. Got "+s);
	}
}
