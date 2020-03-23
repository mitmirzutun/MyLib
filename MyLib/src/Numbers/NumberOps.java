package Numbers;

import java.math.BigInteger;
import java.math.BigDecimal;

public class NumberOps {
	private static BigInteger fibonacci_numbers[]=null;
	public static void main(String[] args) {
		for (int i=0;i<=100;i++) {
			System.out.println(i+" "+fib(i));
		}
	}
	public static long abs(long number) {
		return sign(number)*number;
	}
	public static double abs(double number) {
		return sign(number)*number;
	}
	public static BigInteger abs(BigInteger number) {
		return number.abs();
	}
	public static BigDecimal abs(BigDecimal number) {
		return number.abs();
	}
	public static byte sign(long number) {
		return (byte)(number==0?0:(number<0?-1:1));
	}
	public static byte sign(double number) {
		return (byte)(number==0?0:(number<0?-1:1));
	}
	public static byte sign(BigInteger number) {
		return (byte)number.signum();
	}
	public static byte sign(BigDecimal number) {
		return (byte)number.signum();
	}
	public static long GCD(long...numberArray) {
		if (numberArray==null)
			throw new NullPointerException();
		if (numberArray.length==0)
			throw new ArrayIndexOutOfBoundsException();
		if (numberArray.length==1)
			return numberArray[0];
		if (numberArray.length==2) {
			long num1 = numberArray[0],num2 = numberArray[1];
			while (num2!=0) {
				long tmp=num1%num2;
				num1=num2;
				num2=tmp;
			} return num1;
		}
		for (int i=1;i<numberArray.length;i*=2) {
			for (int j=0;j+i<numberArray.length;j+=2*i) {
				numberArray[j]=GCD(numberArray[j],numberArray[j+i]);
			}
		} return numberArray[0];
	}
	public static BigInteger GCD(BigInteger...numberArray) {
		if (numberArray==null)
			throw new NullPointerException();
		if (numberArray.length==0)
			throw new ArrayIndexOutOfBoundsException();
		if (numberArray.length==1)
			return numberArray[0];
		if (numberArray.length==2) {
			BigInteger num1=numberArray[0],num2=numberArray[2];
			while (sign(num2)!=0) {
				BigInteger tmp=num1.mod(num2);
				num1=num2;
				num2=tmp;
			}
			return num1;
		}
		for (int i=1;i<numberArray.length;i*=2) {
			for (int j=0;j+i<numberArray.length;j+=2*i) {
				numberArray[j]=GCD(numberArray[j],numberArray[j+i]);
			}
		}
		return numberArray[0];
	}
	public static long LCM(long...numberArray) {
		if (numberArray==null)
			throw new NullPointerException();
		if (numberArray.length==0)
			throw new ArrayIndexOutOfBoundsException();
		for (int i=1;i<numberArray.length;i++) {
			for (int j=0;j+i<numberArray.length;j+=2*i) {
				numberArray[j]=numberArray[j]*numberArray[j+i]/GCD(numberArray[j],numberArray[j+i]);
			}
		}
		return numberArray[0];
	}
	public static BigInteger LCM(BigInteger...numberArray) {
		if (numberArray==null)
			throw new NullPointerException();
		if (numberArray.length==0)
			throw new ArrayIndexOutOfBoundsException();
		for (int i=1;i<numberArray.length;i++) {
			for (int j=0;j+i<numberArray.length;j+=2*i) {
				numberArray[j]=numberArray[j].multiply(numberArray[j+i]).divide(GCD(numberArray[i],numberArray[i+j]));
			}
		}
		return numberArray[0];
	}
	public static BigInteger fact(BigInteger n) {
		if (sign(n)<0)
			return BigInteger.valueOf(-1);
		BigInteger num = BigInteger.valueOf(1);
		for (BigInteger i=BigInteger.valueOf(2);sign(i.subtract(n))>=0;i=i.add(BigInteger.valueOf(1))) {
			num=num.multiply(i);
		}
		return num;
	}
	public static BigInteger fib(int n) {
		if (n<0) {
			return BigInteger.valueOf(-1);
		}
		if (fibonacci_numbers==null) {
			fibonacci_numbers=new BigInteger[2];
			fibonacci_numbers[0]=BigInteger.valueOf(0);
			fibonacci_numbers[1]=BigInteger.valueOf(1);
		}
		if (n<fibonacci_numbers.length)
			return fibonacci_numbers[n];
		BigInteger[] tmp= new BigInteger[n+1];
		for (int i=0;i<fibonacci_numbers.length;i++)
			tmp[i]=fibonacci_numbers[i];
		for (int i=fibonacci_numbers.length;i<=n;i++)
			tmp[i]=fibonacci_numbers[i-2].add(fibonacci_numbers[i-1]);
		fibonacci_numbers=tmp;
		return fibonacci_numbers[n];
	}
	public static boolean isPrime(long p) {
		if (p<=1)
			throw new NumberFormatException();
		if (p==2)
			return true;
		if (p%2==0)
			return false;
		for (int i=3;i<=Math.pow(p,.5);i+=2)
			if (p%i==0)
				return false;
		return true;
	}
	public static boolean isPrime(BigInteger p) {
		if (p==null)
			throw new NullPointerException();
		if (sign(p.subtract(BigInteger.valueOf(1)))<=0)
			throw new NumberFormatException();
		if (sign(p.subtract(BigInteger.valueOf(2)))==0)
			return true;
		if (sign(p.mod(BigInteger.valueOf(2)))==0)
			return false;
		for (BigInteger i=BigInteger.valueOf(3);sign(p.subtract(i.multiply(i)))==0;p.add(BigInteger.valueOf(2)))
			if (sign(p.mod(i))==0)
				return false;
		return true;
	}
}
