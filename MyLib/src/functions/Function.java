package functions;

public class Function {
	private double[][] data;
	private static boolean DEBUGGING=false; 
	public static void main(String[] args) {
		double data[][]= {{1,1},{2,2},{3,3},{4,4},{3,7}};
		Function f = new Function(data);
		System.out.println(f.toString());
		f.add(data);
		System.out.println(f.toString());
		f.add(new Function(data));
		f.subtract(data);
		System.out.println(f.toString());
	}
	public Function() {
		if (DEBUGGING) {
			System.out.println("Call of constructorFunction().");
			System.out.println("Initialisation Start.");
			System.out.println("Initialising data storage.");
		}
		data=new double[0][2];
		if (DEBUGGING)
			System.out.println("Initialisation finished.");
	}
	public Function(double[] function) {
		if (DEBUGGING) {
			System.out.println("Call of constructor Function(double[] function).");
			System.out.println("Testing double[] function on integrity.");
		}
		if (function==null || function.length==0) {
			if (DEBUGGING)
				System.out.println("Integrity test failed.");
			return;
		}
		if (DEBUGGING) {
			System.out.println("Initialisation start.");
			System.out.println("Initialising private data storage.");
		}
		data = new double[function.length][2];
		if (DEBUGGING) {
			System.out.println("Copying data from double[] function to data storage.");
			System.out.println("Exponents with coeficient 0 are ignored.");
		}
		int n=0;
		for (int i=0;i<function.length;i++) {
			if (function[i]!=0) {
				if (DEBUGGING)
					System.out.println(data[n][0]+" "+data[n][1]);
				data[n][0]=i;
				data[n][1]=function[i];
				n++;
			}
		}
		if (DEBUGGING)
			System.out.println("Resizing data storage.");
		double[][] tmp = new double[n][2];
		for (int i=0;i<n;i++)
			tmp[i]=data[i];
		data=tmp;
		System.out.println("Initialisation completed.");
	}
	public Function(double[][] function) {
		if (DEBUGGING) {
			System.out.println("Call of constructor Function(double[][] function.");
			System.out.println("Testing double[][] function on integrity.");
		}
		if (function==null||function.length==0||function[0].length!=2) {
			if (DEBUGGING)
				System.out.println("Integrity test failed.");
			return;
		}
		if (DEBUGGING) {
			System.out.println("Initialising start.");
			System.out.println("Initialising data storage.");
		}
		int n=0;
		data = new double[function.length][2];
		if (DEBUGGING)
			System.out.println("Copying data from double[][] function to data storage.");
		for (int i=0;i<function.length;i++) {
			if (function[i][1]!=0) {
				if (DEBUGGING)
					System.out.println(function[i][0]+" "+function[i][1]);
				data[n++]=function[i].clone();
			}
		}
		if (DEBUGGING)
			System.out.println("Resizing data storage");
		double[][] tmp=new double[n][2];
		for (int i=0;i<n;i++)
			tmp[i]=data[i];
		data=tmp;
		if (DEBUGGING)
			System.out.println("Finished initialising.");
	}
	public Function(Function f) {
		if (DEBUGGING) {
			System.out.println("Call of constructor Function(Function f).");
			System.out.println("Testing data storage on integrity");
		}
		if (f.data==null) {
			if (DEBUGGING)
				System.out.println("Integrity test failed");
			return;
		}
		if (DEBUGGING)
			System.out.println("Cloning data");
		this.data=f.data.clone();
		if (DEBUGGING)
			System.out.println("Cloning data finshed");
	}
	/**
	 * Adds another Function to the function
	 */
	public void add(double...factors) {
		if (DEBUGGING) {
			System.out.println("Call of void add(double...factors).");
			System.out.println("Testing double...factors on integrity.");
		}
		if (factors==null || factors.length==0||data==null) {
			if (DEBUGGING)
				System.out.println("Integrity test failed.");
			return;
		}
		System.out.println("Copying data from double...factors into data storage.");
		double tmp[][]=new double[data.length+factors.length][2];
		for (int i=0;i<data.length;i++) {
			if (DEBUGGING)
				System.out.println(data[i][0]+" "+data[i][1]);
			tmp[i]=data[i];
		}
		for (int i=0;i<factors.length;i++) {
			if (factors[i]==0)
				continue;
			if (DEBUGGING) {
				System.out.println(i+" "+factors[i]);
			}
			tmp[i+data.length][0]=i;
			tmp[i+data.length][1]=factors[i];
		}
		data=tmp;
		if (DEBUGGING)
			System.out.println("Initialisation complete.");
	}
	/**
	 * Adds another function to the function
	 * */
	public void add(double[]...factors) {
		if (DEBUGGING) {
			System.out.println("Call of void add(double[]...factors).");
			System.out.println("Testing double[]...factors on integrity");
		}
		if (factors==null || factors.length==0||data==null) {
			if (DEBUGGING)
				System.out.println("Integrity test failed");
			return;
		}
		if (DEBUGGING)
			System.out.println("Copying data from double...factors to data storage");
		double tmp[][]=new double[data.length+factors.length][2];
		for (int i=0;i<data.length;i++) {
			if (DEBUGGING)
				System.out.println(data[i][0]+" "+data[i][1]);
			tmp[i]=data[i];
		}
		for (int i=0;i<factors.length;i++) {
			if (factors[i][1]==0)
				continue;
			if (DEBUGGING)
				System.out.println(factors[i][0]+""+factors[i][1]);
			tmp[i+data.length]=factors[i].clone();
		}
		data=tmp;
		if (DEBUGGING)
			System.out.println("Copying complete");
	}
	/**
	 * Adds another function to the current function
	 * */
	public void add(Function f) {
		if (DEBUGGING) {
			System.out.println("Call of void add(Function f)");
			System.out.println("Testing of integrity of data storage");
		}
		if (f.data==null|this.data==null) {
			if (DEBUGGING) 
				System.out.println("Integrity test failed");
			return;
		}
		add(f.data);
	}
	/**
	 * Cleans up the data storage
	 * */
	public void cleanup() {
		if (DEBUGGING) {
			System.out.println("Cleaning up data storage");
			System.out.println("Sorting data storage");
		}
		if (data==null || data.length==0)
			return;
		{
			double tmp[][][] = new double[data.length][][];
			for (int i=0;i<data.length;i++) {
				double tmp1[][]= {data[i]};
				tmp[i]=tmp1;
			}
			for (int i=1;i<data.length;i*=2) {
				for (int j=0;j+i<data.length;j+=2*i) {
					double tmp1[][] = new double[tmp[j].length+tmp[j+i].length][2];
					int n1=0,n2=0;
					while (n1<tmp[j].length&&n2<tmp[j+i].length) {
						if (tmp[j][n1][0]<=tmp[j+i][n2][0]) {
							tmp1[n1+n2]=tmp[j][n1];
							n1++;
						} else {
							tmp1[n1+n2]=tmp[j+i][n2];
							n2++;
						}
					}
					while (n1<tmp[j].length) {
						tmp1[n1+n2]=tmp[j][n1];
						n1++;
					}
					while (n2<tmp[j+i].length) {
						tmp1[n1+n2]=tmp[j+i][n2];
						n2++;
					}
					tmp[j]=tmp1;
				}
			}
			data=tmp[0];
		}
		System.out.println("Removing exponent duplicates and coefficients==0");
		double tmp[][]=new double[data.length][2];
		tmp[0]=data[0];
		int n=1;
		for (int i=1;i<data.length;i++) {
			if (data[i][0]==0)
				continue;
			if (data[i][0]==tmp[n-1][0]) {
				tmp[n-1][1]+=data[i][1];
			} else {
				tmp[n]=data[i];
				n++;
			}
		}
		data = new double[n][2];
		for (int i=0; i<n;i++)
			data[i]=tmp[i];
		if (DEBUGGING)
			System.out.println("Cleanup complete");
	}
	/**
	 * Returns the String representation of the function
	 * @return String
	 */
	public String toString() {
		if (DEBUGGING)
			System.out.println("Creating String representation");
		if (data==null||data.length==0)
			return "";
		this.cleanup();
		String data[][]=new String[this.data.length][2];
		int length=this.data.length*2-1;
		for (int i=0;i<this.data.length;i++) {
			data[i][0]=Double.toString(this.data[i][0]);
			data[i][1]=Double.toString(this.data[i][1]);
			length+=data[i][0].length()+data[i][1].length();
		}
		StringBuilder tmp = new StringBuilder(length);
		tmp.append(data[0][1]);
		tmp.append("x^");
		tmp.append(data[0][0]);
		for (int i=1;i<data.length;i++) {
			tmp.append("+");
			tmp.append(data[i][1]);
			tmp.append("x^");
			tmp.append(data[i][0]);
		}
		return tmp.toString();
	}
	/**
	 * Returns the length of the function
	 * @return int
	 * */
	public int length() {
		return this.toString().length();
	}
	/**
	 * Subtracts another function from the current function
	 * @param
	 * */
	public void subtract(double...factors) {
		if (data==null||factors==null||factors.length==0)
			return;
		factors = factors.clone();
		for (int i=0;i<factors.length;i++)
			factors[i]=-factors[i];
		this.add(factors);
		this.cleanup();
	}
	/**
	 * Subtracts another function from the current function
	 * @param
	 * */
	public void subtract(double[]...function) {
		if (data==null||function==null||function.length==0)
			return;
		function=function.clone();
		for (int i=0;i<function.length;i++) {
			function[i]=function[i].clone();
			function[i][1]=-function[i][1];
		}
		this.add(function);
		this.cleanup();
	}
	/**
	 * Subtracts another function from the current function
	 * @param
	 * */
	public void subtract(Function f) {
		this.subtract(f.data);
	}
	/**
	 * Returns the integral of the current function
	 * @return Function
	 * */
	public Function integrate() {
		double data[][]=new double[this.data.length][2];
		for (int i=0;i<data.length;i++) {
			data[i][0]=this.data[i][0]+1;
			data[i][1]=this.data[i][1]/data[i][0];
		}
		return new Function(data);
	}
	/**
	 * Returns the Differential of the current function
	 * @return Function
	 * */
	public Function differentiate() {
		double data[][]=new double[this.data.length][2];
		for (int i=0;i<data.length;i++) {
			data[i][0]=this.data[i][0]-1;
			data[i][1]=this.data[i][1]*this.data[i][0];
		}
		return new Function(data);
	}
	public static boolean isDebugging() {
		return DEBUGGING;
	}
	public static void startDebugging() {
		DEBUGGING=true;
	}
	public static void stopDebugging() {
		DEBUGGING=false;
	}
	public double valueAt(double x) {
		double n=0;
		for (int i=0;i<data.length;i++)
			n+=Math.pow(data[i][1], data[i][0]);
		return n;
	}
}
