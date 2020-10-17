package math;
import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * @author Milan Cieliebak
 * @version Alpha 0.0.0
 * */
public class MathOps {
	/**
	 * @param
	 * @return The absolute value of bi
	 * */
	public static BigInteger abs(BigInteger bi) {
		return bi.abs();
	}
	/**
	 * @param
	 * @return the absolute value of bd
	 * */
	public static BigDecimal abs(BigDecimal bd) {
		return bd.abs();
	}
	/**
	 * @param
	 * @return the absolute value of l
	 * */
	public static long abs(long l) {
		return l<0?-l:l;
	}
	/**
	 * @param
	 * @return the absolute value of d
	 * */
	public static double abs(double d) {
		return d<0?-d:d;
	}
	/**
	 * @param
	 * @return the sign of bi
	 * */
	public static int sign(BigInteger bi) {
		try {
			return bi.divide(abs(bi)).intValue();
		} catch (ArithmeticException ae) {
			return 0;
		}
	}
	/**
	 * @param
	 * @return the sign of bd
	 * */
	public static int sign(BigDecimal bd) {
		try {
			return bd.divide(abs(bd)).intValue();
		} catch (ArithmeticException ae) {
			return 0;
		}
	}
	/**
	 * @param
	 * @return the sign of l
	 * */
	public static int sign(long l) {
		return sign(BigInteger.valueOf(l));
	}
	/**
	 * @param 
	 * @return the sign of d
	 * */
	public static int sign(double d) {
		return sign(BigDecimal.valueOf(d));
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(long a,long b) {
		return greaterThan(BigInteger.valueOf(a),BigInteger.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */	
	public static boolean greaterThan(BigInteger a, long b) {
		return greaterThan(a,BigInteger.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(long a, BigInteger b) {
		return greaterThan(BigInteger.valueOf(a),b);
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(BigInteger a, BigInteger b) {
		return sign(a.subtract(b))==1;
	}
}
