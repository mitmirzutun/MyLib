package test.functions;

import java.math.BigInteger;
import java.util.*;
import math.MathOps;

public class Test {
	public static void main(String...args) {
		for (int i=0;i<=400;i++) {
			System.out.println(i+" "+yearDifference(i));
		}
	}
	public static BigInteger mod(BigInteger b, BigInteger e, BigInteger m) {
		HashMap<BigInteger,BigInteger> data=new HashMap<BigInteger,BigInteger>();
		BigInteger power=BigInteger.ONE,res=BigInteger.ONE;
		b=b.mod(m);
		data.put(power, b);
		while (MathOps.lessOrEquals(power, e)) {
			power=power.multiply(BigInteger.valueOf(2));
			b=(b.multiply(b)).mod(m);
			data.put(power, b);
		}
		while (MathOps.greaterThan(e, BigInteger.ZERO)) {
			if (MathOps.greaterOrEquals(e, power)) {
				res=res.multiply(data.get(power));
				res=res.mod(m);
				e=e.subtract(power);
			}
			power=power.divide(BigInteger.valueOf(2));
		}
		return res;
	}
	public static long yearDifference(long year) {
		if (year<0)
			return 0;
		long a=year,b=0;
		do {
			a++;
			b+=(a%4==0&&a%100!=0||a%400==0)?2:1;
		} while (b%7!=0);
		return a-year;
	}
}
