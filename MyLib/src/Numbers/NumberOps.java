package Numbers;

import java.math.BigInteger;

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
	public static byte sign(long number) {
		return (byte)(number==0?0:(number<0?-1:1));
	}
	public static byte sign(double number) {
		return (byte)(number==0?0:(number<0?-1:1));
	}
	public static long GCD(long...numberArray) {
		if (numberArray==null||numberArray.length==0)
			return 1;
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
	public static long LCM(long...numberArray) {
		if (numberArray==null||numberArray.length==0)
			return 1;
		for (int i=1;i<numberArray.length;i++) {
			for (int j=0;j+i<numberArray.length;j+=2*i) {
				numberArray[j]=numberArray[j]*numberArray[j+i]/GCD(numberArray[j],numberArray[j+i]);
			}
		}
		return numberArray[0];
	}
	public static double pow(double base,double exponent) {
		if (exponent<0) {
			base=1/base;
			exponent*=-1;
		} if (exponent<1) {
			return 1;
		} if (exponent%1>0) {
			return pow(base,exponent-exponent%1)*pow(base,exponent%1);
		}
		int num=1;
		while (exponent>0) {
			if (exponent%2==1) {
				num*=base;
				exponent-=1;
			}
			base*=base;
			exponent/=2;
		}
		return num;
	}
	public static BigInteger fact(long n) {
		if (n<0)
			return BigInteger.valueOf(-1);
		BigInteger num = BigInteger.valueOf(1);
		for (BigInteger i=BigInteger.valueOf(2);i.intValue()<=n;i=i.add(BigInteger.valueOf(1))) {
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
}
