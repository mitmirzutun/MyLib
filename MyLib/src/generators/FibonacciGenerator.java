package generators;

import java.math.BigInteger;

import exceptions.IllegalValueException;
import math.MathOps;

public class FibonacciGenerator extends Generator {
	private BigInteger a,b,n,max;
 	public FibonacciGenerator() {
		super(false);
		a=BigInteger.ZERO;
		b=BigInteger.ONE;
		n=BigInteger.ZERO;
		max=BigInteger.ZERO;
	}
	public FibonacciGenerator(BigInteger stop) {
		this(BigInteger.ZERO,stop);
	}
	public FibonacciGenerator(BigInteger start,BigInteger stop){
		super(true);
		if (MathOps.lessThan(stop, start))
			throw new IllegalValueException("Expected start("+start+") to be less or equals than stop("+stop+"). Stop smaller than start.");
		a=BigInteger.ZERO;
		b=BigInteger.ONE;
		n=BigInteger.ZERO;
		max=stop;
		while (MathOps.lessThan(n, start)) {
			BigInteger tmp=a.add(b);
			a=b;
			b=tmp;
			n=n.add(BigInteger.ONE);
		}
	}
	public FibonacciGenerator(long stop)  {
		this(0,stop);
	}
	public FibonacciGenerator(long start, long stop) {
		this(BigInteger.valueOf(start),BigInteger.valueOf(stop));
	}
	public BigInteger next() {
		if (!hasNext())
			return null;
		BigInteger retVal=a,tmp=a.add(b);
		a=b;
		b=tmp;
		n=n.add(BigInteger.ONE);
		return retVal;
	}
	public boolean hasNext() {
		return (this.isInfinite()||MathOps.lessThan(n, max));
	}
	public static void main(String args[]) {
		FibonacciGenerator fib=new FibonacciGenerator(3,10);
		while (fib.hasNext())
			System.out.println(fib.next());
		fib=new FibonacciGenerator(10,3);
	}
}
