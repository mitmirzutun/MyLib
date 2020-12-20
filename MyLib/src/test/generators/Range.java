package test.generators;

import java.math.BigDecimal;
import java.math.BigInteger;

import exceptions.EndOfGeneratorException;
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
	public BigDecimal generate() {
		if (MathOps.sign(step)==0||
		   (MathOps.lessOrEquals(n, stop)&&MathOps.sign(step)<0||
		    MathOps.greaterOrEquals(n, stop)&&MathOps.sign(step)>0))
			throw new EndOfGeneratorException();
		BigDecimal nextVal=n;
		n=n.add(step);
		return nextVal;
	}
	public static void main(String...args) {
		Generator g=new Range(500);
		while (true) {
			try  {
				System.out.println(g.generate());
			} catch (EndOfGeneratorException e) {
				break;
			}
		}
	}
}
