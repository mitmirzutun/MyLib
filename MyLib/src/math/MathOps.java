package math;
import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * @author Milan Cieliebak
 * @version Alpha 0.0.0
 * */
public class MathOps {
	public static void main(String...args) {
		for (int i=0;i<10;i++)
			System.out.println(i+" "+fak(i)+" "+fib(-i));
	}
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
	 * @return 1 if bi is positive, 0 if bi is 0, -1 if bi is negative
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
	 * @return 1 if bd is positive, 0 if bd is 0, -1 if bd is negative
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
	 * @return 1 if l is positive, 0 if l is 0, -1 if l is negative
	 * */
	public static int sign(long l) {
		return sign(BigInteger.valueOf(l));
	}
	/**
	 * @param
	 * @return 1 if d is positive, 0 if d is 0, -1 if d is negative
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
		if (sign(a)==1&&sign(b)==1) 
			return sign(a.subtract(b))==1;
		if (sign(a)==1)
			return true;
		if (sign(a)==0&&sign(b)==-1)
			return true;
		if (sign(a)==0)
			return false;
		if (sign(a)==-1&&sign(b)==-1)
			return sign(abs(a).subtract(abs(b)))==1;
		return false;
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(double a, double b) {
		return greaterThan(BigDecimal.valueOf(a),BigDecimal.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(BigDecimal a, double b) {
		return greaterThan(a,BigDecimal.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(double a, BigDecimal b) {
		return greaterThan(BigDecimal.valueOf(a),b);
	}
	/**
	 * @param
	 * @return true if a is bigger than b
	 * */
	public static boolean greaterThan(BigDecimal a, BigDecimal b) {
		if (sign(a)==1&&sign(b)==1) 
			return sign(a.subtract(b))==1;
		if (sign(a)==1)
			return true;
		if (sign(a)==0&&sign(b)==-1)
			return true;
		if (sign(a)==0)
			return false;
		if (sign(a)==-1&&sign(b)==-1)
			return sign(abs(a).subtract(abs(b)))==1;
		return false;
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(long a, long b) {
		return equals(BigInteger.valueOf(a),BigInteger.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(long a, BigInteger b) {
		return equals(BigInteger.valueOf(a),b);
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(BigInteger a, long b) {
		return equals(a,BigInteger.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(BigInteger a, BigInteger b) {
		if (sign(a)==0&&sign(b)==0)
			return true;
		if (sign(a)==1&&sign(b)==1)
			return sign(a.subtract(b))==0;
		if (sign(a)==-1&&sign(b)==-1)
			return sign(abs(a).subtract(abs(b)))==0;
		return false;
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(double a, double b) {
		return equals(BigDecimal.valueOf(a),BigDecimal.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(double a, BigDecimal b) {
		return equals(BigDecimal.valueOf(a),b);
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(BigDecimal a, double b) {
		return equals(a,BigDecimal.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a and b are equal
	 * */
	public static boolean equals(BigDecimal a, BigDecimal b) {
		if (sign(a)==sign(b))
			return sign(abs(a).subtract(b))==0;
		return false;
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(long a, long b) {
		return lessThan(BigInteger.valueOf(a),BigInteger.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(long a, BigInteger b) {
		return lessThan(BigInteger.valueOf(a),b);
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(BigInteger a, long b) {
		return lessThan(a,BigInteger.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(BigInteger a, BigInteger b) {
		return greaterThan(b,a);
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(double a, double b) {
		return lessThan(BigDecimal.valueOf(a),BigDecimal.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(double a, BigDecimal b) {
		return lessThan(BigDecimal.valueOf(a),b);
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(BigDecimal a, double b) {
		return lessThan(a,BigDecimal.valueOf(b));
	}
	/**
	 * @param
	 * @return true if a is less than b
	 * */
	public static boolean lessThan(BigDecimal a, BigDecimal b) {
		return greaterThan(b,a);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(long a,long b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(long a,BigInteger b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(BigInteger a,long b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(BigInteger a,BigInteger b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(double a,double b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(double a,BigDecimal b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(BigDecimal a,double b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is greater or equal to b
	 * */
	public static boolean greaterOrEquals(BigDecimal a,BigDecimal b) {
		return greaterThan(a,b)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(long a, long b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(BigInteger a, long b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(long a, BigInteger b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(BigInteger a, BigInteger b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(double a, double b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(double a, BigDecimal b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(BigDecimal a, double b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return true if a is less or equal to b
	 * */
	public static boolean lessOrEquals(BigDecimal a, BigDecimal b) {
		return greaterThan(b,a)||equals(a,b);
	}
	/**
	 * @param
	 * @return the greatest common divisor of the list
	 * */
	public static long GCD(Long...list) {
		if (list.length==0)
			return 0;
		if (list.length==1)
			return list[0];
		if (list.length==2) {
			long a=list[0],b=list[1];
			while (b!=0) {
				long tmp=a%b;
				a=b;
				b=tmp;
			}
			return a;
		}
		long res=GCD(list[0],list[1]);
		for (int i=0;i<list.length;i++)
			res=GCD(res,list[i]);
		return res;
	}
	/**
	 * @param
	 * @return the greatest common divisor of the list
	 * */
	public static BigInteger GCD(Object...list) {
		BigInteger res=BigInteger.ZERO;
		for (Object obj:list) {
			if (obj instanceof BigInteger)
				res=GCD(res,(BigInteger)obj);
			else if (obj instanceof Long)
				res=GCD(res,BigInteger.valueOf((Long)obj));
			else if (obj instanceof Integer)
				res=GCD(res,BigInteger.valueOf((Integer)obj));
		}
		return res;
	}
	/**
	 * @param
	 * @return the greatest common divisor of the list
	 * */
	public static long GCD(Integer...list) {
		if (list.length==0)
			return 0;
		if (list.length==1)
			return list[0];
		if (list.length==2)
			return GCD((long)list[0],(long)list[1]);
		long res=GCD(list[0],list[1]);
		for (int i=2;i<list.length;i++)
			res=GCD(res,(long)list[i]);
		return res;
	}
	/**
	 * @param the greatest common divisor of the list
	 * */
	public static BigInteger GCD(BigInteger...list) {
		if (list.length==0)
			return BigInteger.ZERO;
		if (list.length==1)
			return list[0];
		if (list.length==2) {
			BigInteger a=list[0],b=list[1];
			while (!equals(b,BigInteger.ZERO)) {
				BigInteger tmp=a.modPow(BigInteger.ONE, b);
				a=b;
				b=tmp;
			}
			return a;
		}
		BigInteger res=GCD(list[0],list[1]);
		for (int i=2;i<list.length;i++)
			res=GCD(res,list[i]);
		return res;
	}
	/**
	 * @param
	 * @return the n-th Fibonacci number
	 * */
	public static BigInteger fib(long n) {
		return fib(BigInteger.valueOf(n));
	}
	/**
	 * @param
	 * @return the n-th Fibonacci number
	 * */
	public static BigInteger fib(BigInteger n) {
		if (sign(n)==-1&&equals(n.mod(BigInteger.valueOf(2)),0))
			return BigInteger.valueOf(-1).multiply(fib(abs(n)));
		if (sign(n)==-1)
			return fib(abs(n));
		if (lessThan(n, 2))
			return n;
		BigInteger a=BigInteger.ONE,b=BigInteger.ONE;
		for (BigInteger bi=BigInteger.valueOf(2);!equals(bi, n);bi=bi.add(BigInteger.ONE)) {
			BigInteger tmp=a.add(b);
			b=a;
			a=tmp;
		}
		return a;
	}
	/**
	 * @param
	 * @return n!
	 * */
	public static BigInteger fak(long n) {
		return fak(BigInteger.valueOf(n));
	}
	/**
	 * @param
	 * @return n!
	 * */
	public static BigInteger fak(BigInteger n) {
		if (sign(n)==-1)
			throw new exceptions.NegativeNumberException();
		BigInteger res=BigInteger.ONE;
		for (BigInteger bi=BigInteger.valueOf(2);!greaterThan(bi,n);bi=bi.add(BigInteger.ONE))
			res=res.multiply(bi);
		return res;
	}
	/**
	 * @param
	 * @return
	 * */
	public static BigInteger nCr(long n,long r) {
		return fak(n).divide(fak(r).multiply(BigInteger.valueOf(n).subtract(BigInteger.valueOf(r))));
	}
	/**
	 * @param
	 * @return
	 * */
	public static BigInteger nCr(long n,BigInteger r) {
		return fak(n).divide(fak(r).multiply(BigInteger.valueOf(n).subtract(r)));
	}
	/**
	 * @param
	 * @return
	 * */
	public static BigInteger nCr(BigInteger n,long r) {
		return fak(n).divide(fak(r).multiply(n.subtract(BigInteger.valueOf(r))));
	}
	/**
	 * @param
	 * @return
	 * */
	public static BigInteger nCr(BigInteger n,BigInteger r) {
		return fak(n).divide(fak(r).multiply(n.subtract(r)));
	}
}