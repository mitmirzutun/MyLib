package math;
import java.math.*;
import exceptions.*;
public class Vector {
	private BigDecimal[] coordinates;
	public static void main(String[] args) {
		Object[]d= {5,7};
		System.out.println(new Vector(d));
	}
	public Vector(Object[] coordinates) {
		this.coordinates=new BigDecimal[coordinates.length];
		for (int i=0;i<coordinates.length;i++) {
			if (coordinates[i] instanceof BigDecimal) 
				this.coordinates[i]=(BigDecimal)coordinates[i];
			else if (coordinates[i] instanceof Long) 
				this.coordinates[i]=BigDecimal.valueOf((Long)coordinates[i]);
			else if (coordinates[i] instanceof Integer) 
				this.coordinates[i]=BigDecimal.valueOf((Integer)coordinates[i]);
			else if (coordinates[i] instanceof Double) 
				this.coordinates[i]=BigDecimal.valueOf((Double)coordinates[i]);
			else if (coordinates[i] instanceof Float) 
				this.coordinates[i]=BigDecimal.valueOf((Float)coordinates[i]);
			else
				throw new IllegalArgumentTypeException();
		}
	}
	public Vector (Vector v) {
		this.coordinates=v.coordinates;
	}
	public Vector(int axes) {
		if (axes<1)
			throw new InvalidNumberOfAxesException();
		this.coordinates=new BigDecimal[axes];
		for (int i=0;i<axes;i++)
			this.coordinates[i]=BigDecimal.ZERO;
	}
	public BigDecimal getCoordinate(int axisNumber) {
		if (axisNumber<0||axisNumber>=this.coordinates.length)
			throw new IllegalArgumentException();
		return this.coordinates[axisNumber];
	}
	public BigDecimal abs() {
		BigDecimal sum=BigDecimal.ZERO;
		for (BigDecimal d:coordinates)
			sum=sum.add(d.multiply(d));
		return sum.sqrt(new MathContext(sum.scale()));
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("("+coordinates[0]);
		for (int i=1;i<coordinates.length;i++)
			sb.append("|"+coordinates[i]);
		sb.append(')');
		return sb.toString();
	}
	public Vector add(Vector v) {
		if (v.coordinates.length!=this.coordinates.length)
			throw new InvalidVectorException();
		BigDecimal[] coordinates=new BigDecimal[v.coordinates.length];
		for (int i=0;i<v.coordinates.length;i++)
			coordinates[i]=this.coordinates[i].add(v.coordinates[i]);
		return new Vector(coordinates);
	}
	public Vector subtract(Vector v) {
		if (v.coordinates.length!=this.coordinates.length)
			throw new InvalidVectorException();
		BigDecimal[] coordinates=new BigDecimal[v.coordinates.length];
		for (int i=0;i<v.coordinates.length;i++)
			coordinates[i]=this.coordinates[i].subtract(v.coordinates[i]);
		return new Vector(coordinates);
	}
	public Vector multiply(BigDecimal scalar) {
		BigDecimal[] coordinates=new BigDecimal[this.coordinates.length];
		for (int i=0;i<this.coordinates.length;i++)
			coordinates[i]=this.coordinates[i].multiply(scalar);
		return new Vector(coordinates);
	}
	public Vector multiply(double scalar) {
		return this.multiply(BigDecimal.valueOf(scalar));
	}
	public Vector divide(BigDecimal scalar) {
		BigDecimal[] coordinates=new BigDecimal[this.coordinates.length];
		for (int i=0;i<this.coordinates.length;i++)
			coordinates[i]=this.coordinates[i].divide(scalar);
		return new Vector(coordinates);
	}
	public Vector divide(double scalar) {
		return this.divide(BigDecimal.valueOf(scalar));
	}
	public BigDecimal distanceFrom(Vector v) {
		return this.subtract(v).abs();
	}
	public boolean equals(Object o) {
		if (!(o instanceof Vector))
			return false;
		Vector v=(Vector)o;
		if (this.coordinates.length!=v.coordinates.length)
			return false;
		for (int i=0;i<this.coordinates.length;i++)
			if (!this.coordinates[i].equals(v.coordinates[i]))
				return false;
		return true;
	}
}
