package test.functions;

import java.math.BigInteger;
import java.util.*;
import exceptions.IllegalArgumentTypeException;
import math.MathOps;

public class Test {
	public static void main(String...args) {
		for (int i=0;i<=400;i++) {
			System.out.println(i+" "+yearDifference(i));
		}
	}
	public static Object GCD(Object...objects) {
		if (objects.length==0)
			return BigInteger.ZERO;
		if (objects.length==1) {
			Object o=objects[0];
			if (!(o instanceof Integer)&&!(o instanceof Long)&&!(o instanceof BigInteger))
				throw new IllegalArgumentTypeException();
			return objects[0];
		}
		if (objects.length==2) {
			Object o0=objects[0],o1=objects[1];
			if ((o0 instanceof Long||o0 instanceof Integer)&&(o1 instanceof Long||o1 instanceof Integer)) {
				long a=MathOps.abs((long)o0),b=MathOps.abs((long)o1),tmp;
				while (b!=0) {
					tmp=a%b;
					a=b;
					b=tmp;
				}
				return a;
			}
			if ((o0 instanceof Long||o0 instanceof Integer)&&o1 instanceof BigInteger)
				return GCD(BigInteger.valueOf((long)o0),o1);
			if (o0 instanceof BigInteger&&(o1 instanceof Long||o1 instanceof Integer))
				return GCD(o0,BigInteger.valueOf((long)o1));
			if (o0 instanceof BigInteger&&o1 instanceof BigInteger) {
				BigInteger a=MathOps.abs((BigInteger)o0),b=MathOps.abs((BigInteger)o1),tmp;
				while (!MathOps.equals(b, BigInteger.ZERO)) {
					tmp=a.mod(b);
					a=b;
					b=tmp;
				}
				return a;
			}
			throw new IllegalArgumentTypeException();
		}
		Object res=GCD(objects[0],objects[1]);
		for (int i=2;i<objects.length;i++)
			res=GCD(res,objects[i]);
		return res;
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
