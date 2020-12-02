package generators;

import java.math.BigDecimal;
import java.math.BigInteger;

import math.MathOps;

public class Range extends Generator {
	BigDecimal n,stop,step;
	public Range(Object stop) {
		this(0,stop);
	}
	public Range(Object start,Object stop) {
		this(start,stop,1);
	}
	public Range(Object start,Object stop,Object step) {
		super(true);
		if (start instanceof Integer) {
			start=BigInteger.valueOf((Integer)start);
		}
		if (start instanceof Long) {
			start=BigInteger.valueOf((Long)start);
		}
		if (start instanceof Float) {
			start=new BigDecimal((float)start);
		}
		if (start instanceof Double) {
			start=new BigDecimal((Double)start);
		}
		if (start instanceof BigDecimal) {
			n=(BigDecimal)start;
		} else if (start instanceof BigInteger) {
			n=new BigDecimal((BigInteger)start);
		}
		if (stop instanceof Integer) {
			stop=BigInteger.valueOf((Integer)stop);
		}
		if (stop instanceof Long) {
			stop=BigInteger.valueOf((Long)stop);
		}
		if (stop instanceof Float) {
			stop=new BigDecimal((float)stop);
		}
		if (start instanceof Double) {
			stop=new BigDecimal((Double)stop);
		}
		if (stop instanceof BigDecimal) {
			this.stop=(BigDecimal)stop;
		} else if (stop instanceof BigInteger) {
			this.stop=new BigDecimal((BigInteger)stop);
		}
		if (step instanceof Integer) {
			step=BigInteger.valueOf((Integer)step);
		}
		if (step instanceof Long) {
			step=BigInteger.valueOf((Long)step);
		}
		if (step instanceof Float) {
			step=new BigDecimal((float)step);
		}
		if (step instanceof Double) {
			step=new BigDecimal((Double)step);
		}
		if (step instanceof BigDecimal) {
			this.step=(BigDecimal)step;
		} else if (step instanceof BigInteger) {
			this.step=new BigDecimal((BigInteger)step);
		}
	}
	public BigDecimal next() {
		if (!hasNext())
			return null;
		BigDecimal nextVal=n;
		n=n.add(step);
		return nextVal;
	}
	public boolean hasNext() {
		return (MathOps.sign(step)!=0&&
				(MathOps.greaterThan(n, stop)&&MathOps.sign(step)<0||
				 MathOps.lessThan(n, stop)&&MathOps.sign(step)>0));
	}
	public static void main(String...args) {
		Range range=new Range(15,5,-1);
		while(range.hasNext())
			System.out.println(range.next());
	}
}
