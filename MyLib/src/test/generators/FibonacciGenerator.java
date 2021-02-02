package test.generators;

import java.math.BigInteger;

import exceptions.EndOfGeneratorException;

public class FibonacciGenerator extends Generator<BigInteger> {
	private BigInteger n,a,b,stop;
	public FibonacciGenerator(long stop) {
		this(BigInteger.ZERO,BigInteger.valueOf(stop));
	}
	public FibonacciGenerator(long start, long stop) {
		this(BigInteger.valueOf(start),BigInteger.valueOf(stop));
	}
	public FibonacciGenerator(BigInteger stop) {
		this(BigInteger.ZERO,stop);
	}
	public FibonacciGenerator(BigInteger start, BigInteger stop) {
		n=BigInteger.ZERO;
		a=BigInteger.ZERO;
		b=BigInteger.ONE;
		this.stop=stop;
		while (!math.MathOps.equals(start, n)) {
			BigInteger tmp=a.add(b);
			a=b;
			b=tmp;
			n=n.add(BigInteger.ONE);
		}
	}
	public boolean hasNext() {
		return math.MathOps.lessThan(n, stop);
	}
	public BigInteger next() {
		if (!hasNext()) 
			throw new EndOfGeneratorException();
		BigInteger tmp1,tmp2;
		tmp1=a;
		tmp2=a.add(b);
		a=b;
		b=tmp2;
		n=n.add(BigInteger.ONE);
		return tmp1;
	}
	public static void main(String[] args) {
		Generator<BigInteger> g= new FibonacciGenerator(65536);
		while (g.hasNext()) {
			System.out.println(g.next());
		}
	}
}
