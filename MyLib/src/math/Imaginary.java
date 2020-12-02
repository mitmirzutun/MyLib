package math;

import java.math.BigDecimal;

public class Imaginary {
	private BigDecimal a,b;
	private boolean isCoords;
	public static final Imaginary ZERO=new Imaginary(0,0);
	public static final Imaginary I=new Imaginary(0,1);
	public Imaginary(double a,double b) {
		this(a,b,true);
	}
	public Imaginary(double a,double b,boolean isCoords) {
		this.a=BigDecimal.valueOf(a);
		this.b=BigDecimal.valueOf(b);
		this.isCoords=isCoords;
	}
	public Imaginary(double a,BigDecimal b) {
		this(a,b,true);
	}
	public Imaginary(double a,BigDecimal b,boolean isCoords) {
		this.a=BigDecimal.valueOf(a);
		this.b=b;
		this.isCoords=isCoords;
	}
	public Imaginary(BigDecimal a,double b) {
		this(a,b,true);
	}
	public Imaginary(BigDecimal a,double b,boolean isCoords) {
		this.a=a;
		this.b=BigDecimal.valueOf(b);
		this.isCoords=isCoords;
	}
	public Imaginary(BigDecimal a,BigDecimal b) {
		this(a,b,true);
	}
	public Imaginary(BigDecimal a,BigDecimal b,boolean isCoords) {
		this.a=a;
		this.b=b;
		this.isCoords=isCoords;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		if (isCoords) {
			sb.append(a);
			sb.append("+");
			sb.append(b);
			sb.append('i');
		} else {
			sb.append(a);
			sb.append("*e^(");
			sb.append(b);
			sb.append("i)");
		}
		return sb.toString();
	}
}