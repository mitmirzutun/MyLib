package test.functions;

import java.math.BigInteger;
import exceptions.IllegalArgumentTypeException;
import math.MathOps;

public class Test {
	public static void main(String...args) {
		System.out.println(GCD(4,6));
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
}
