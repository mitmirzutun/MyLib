package test.generators;

import java.math.BigInteger;

import exceptions.EndOfGeneratorException;
import exceptions.IllegalValueException;
import math.MathOps;

public class FibonacciGenerator extends Generator {
	private BigInteger a,b,n,end;
	public FibonacciGenerator(long end) {
		this(BigInteger.ZERO,BigInteger.valueOf(end));
	}
	public FibonacciGenerator(long start, long end) {
		this(BigInteger.valueOf(start),BigInteger.valueOf(end));
	}
	public FibonacciGenerator(BigInteger end)  {
		this(BigInteger.ZERO,end);
	}
	public FibonacciGenerator(BigInteger start, BigInteger end) {
		if (MathOps.lessThan(end, start))
			throw new IllegalValueException("Expected start("+start+") to be less or equals than stop("+end+"). Stop smaller than start.");
		a=BigInteger.ZERO;
		b=BigInteger.ONE;
		n=BigInteger.ZERO;
		this.end=end;
		for (;MathOps.lessThan(n,start);n=n.add(BigInteger.ONE)) {
			BigInteger tmp=a.add(b);
			a=b;
			b=tmp;
		}
	}
	public BigInteger generate() {
		if (MathOps.equals(n, end))
			throw new EndOfGeneratorException();
		BigInteger tmp1=a.add(b),tmp2=a;
		a=b;
		b=tmp1;
		n=n.add(BigInteger.ONE);
		return tmp2;
	}
	public static void main(String...args) {
		Generator g=new FibonacciGenerator(10);
		while (true) {
			try {
				System.out.println(g.generate());
			} catch (EndOfGeneratorException e) {
				break;
			}
		}
	}
}
