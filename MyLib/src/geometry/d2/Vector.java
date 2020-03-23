package geometry.d2;

public class Vector extends geometry.Vector {
	private double x,y;
	public Vector() {
		x=1;
		y=1;
	}
	public Vector(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public Vector(Vector v) {
		this.x=v.x;
		this.y=v.y;
	}
	public double length() {
		return Math.pow(x*x+y*y, .5);
	}
	public boolean equals(Object o) {
		return (o instanceof geometry.d2.Vector)?this.toString().equals(o.toString()):false;
	}
	public String toString() {
		String x=Double.toString(this.x),y=Double.toString(this.y);
		StringBuilder sb= new StringBuilder(y.length()+x.length()+8);
		sb.append("x: ");
		sb.append(x);
		sb.append("y: ");
		sb.append(y);
		return sb.toString();
	}
}
