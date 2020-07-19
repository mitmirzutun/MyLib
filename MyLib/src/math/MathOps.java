package math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathOps {
	public static BigInteger abs(BigInteger bi) {
		return bi.abs();
	}
	public static BigDecimal abs(BigDecimal bd) {
		return bd.abs();
	}
	public static long abs(long l) {
		return l<0?-l:l;
	}
	public static double abs(double d) {
		return d<0?-d:d;
	}
	public static int sign(BigInteger bi) {
		try {
			return bi.divide(abs(bi)).intValue();
		} catch (ArithmeticException ae) {
			return 0;
		}
	}
	public static int sign(BigDecimal bd) {
		try {
			return bd.divide(abs(bd)).intValue();
		} catch (ArithmeticException ae) {
			return 0;
		}
	}
	public static int sign(long l) {
		return sign(BigInteger.valueOf(l));
	}
	public static int sign(double d) {
		return sign(BigDecimal.valueOf(d));
	}
}
