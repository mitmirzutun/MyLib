package math;

import java.math.BigDecimal;
import exceptions.*;

public class Matrix {
	private BigDecimal[][] data;
	public static void main(String...args) {
		BigDecimal[][] bd1=new BigDecimal[2][3],bd2=new BigDecimal[3][2];
		for (int i=0;i<2;i++) {
			for (int j=0;j<3;j++) {
				bd1[i][j]=new BigDecimal(i*3+j+1);
				bd2[j][i]=new BigDecimal(10+j*10+i);
			}
		}
		System.out.println(new Matrix(bd2).multiply(new Matrix(bd1)));
	}
	public Matrix(Object[][] data) {
		this.data=new BigDecimal[data.length][data[0].length];
		for (int i=0;i<data.length;i++) {
			if (data[i].length!=data[0].length)
				throw new InvalidMatrixException();
			for (int j=0;j<data[0].length;j++) {
				if (data[i][j] instanceof BigDecimal) 
					this.data[i][j]=(BigDecimal)data[i][j];
				else if (data[i][j] instanceof Long) 
					this.data[i][j]=BigDecimal.valueOf((Long)data[i][j]);
				else if (data[i][j] instanceof Integer) 
					this.data[i][j]=BigDecimal.valueOf((Integer)data[i][j]);
				else if (data[i][j] instanceof Double) 
					this.data[i][j]=BigDecimal.valueOf((Double)data[i][j]);
				else if (data[i][j] instanceof Float) 
					this.data[i][j]=BigDecimal.valueOf((Float)data[i][j]);
				else
					throw new IllegalArgumentTypeException();
			}
		}
	}
	public Matrix(Matrix m) {
		this.data=m.data.clone();
	}
	public Matrix(int m,int n) {
		this.data=new BigDecimal[m][n];
		for (int i=0;i<m;i++)
			for (int j=0;j<n;j++)
				this.data[i][j]=BigDecimal.ZERO;
	}
	public Matrix add(Matrix other) {
		if (this.data.length!=other.data.length||this.data[0].length!=other.data[0].length)
			throw new InvalidMatrixLengthException();
		BigDecimal[][] data=new BigDecimal[this.data.length][this.data[0].length];
		for (int i=0;i<data.length;i++)
			for (int j=0;j<data[0].length;j++)
				data[i][j]=this.data[i][j].add(other.data[i][j]);
		return new Matrix(data);
	}
	public Matrix multiply(Matrix other) {
		if (this.data[0].length!=other.data.length)
			throw new InvalidMatrixLengthException();
		BigDecimal[][] data=new BigDecimal[this.data.length][other.data[0].length];
		for (int line=0;line<this.data.length;line++) {
			for (int col=0;col<data[0].length;col++) {
				for (int m=0;m<this.data[0].length;m++) {
					data[line][col]=this.data[line][m].multiply(other.data[m][col]);
				}
			}
		}
		return new Matrix(data);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (BigDecimal[] line:data) {
			sb.append(line[0]);
			for (int i=1;i<line.length;i++) {
				sb.append(";"+line[i]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
