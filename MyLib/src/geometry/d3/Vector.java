package geometry.d3;

public class Vector extends geometry.Vector{
	private final double x,y,z;
	public Vector() {
		x=1;
		y=1;
		z=1;
	}
	public Vector(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public double length() {
		return Math.pow(x*x+y*y+z*z, .5);
	}
	public boolean equals(Object o) {
		if (!(o instanceof geometry.d3.Vector))
			return false;
		return this.toString().contentEquals(o.toString());
	}
	public String toString() {
		String x=Double.toString(this.x),y=Double.toString(this.y),z=Double.toString(this.z);
		StringBuilder sb= new StringBuilder(z.length()+y.length()+x.length()+8);
		sb.append("x: ");
		sb.append(x);
		sb.append("y: ");
		sb.append(y);
		sb.append("z: ");
		sb.append(z);
		return sb.toString();
	}
}
