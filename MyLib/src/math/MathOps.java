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
}
