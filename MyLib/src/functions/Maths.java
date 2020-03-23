package functions;

public class Maths {
	/**
	 * returns the natural logarithm of x
	 * @param
	 * @return double
	 * */
	public static double ln(double x) {
		if (x<=0)
			return 0;
		x=(x-1)/(x+1);
		double z=x*x*x,n1=x*2,n2=3;
		while (n1+2*z/n2!=n1) {
			n1+=2*z/n2;
			z*=x*x;
			n2+=2;
		}
		return n1;
	}
	/**
	 * returns the logarithm of the number n to the base b
	 * */
	public static double log(double n, double b) {
		return ln(n)/ln(b);
	}
	/**
	 * returns the number e
	 * */
	public static double exp() {
		return exp(1);
	}
	/**
	 * returns the number e to the power of x
	 * */
	public static double exp(double x) {
		double n=1+x,n1=x*x/2,n2=3;
		while (n+n1!=n) {
			n+=n1;
			n1*=x/n2;
			n2+=1;
		}
		return n;
	}
	
}
