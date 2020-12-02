package generators;

public class Combination extends Generator {
	private Object first,currList[],obj[];
	private Combination p;
	private int n;
	public Combination(Object[] obj) {
		super(true);
		this.obj=obj.clone();
		first=obj[0];
		if (obj.length>1) {
			Object[] clone=new Object[obj.length-1];
			for (int i=1;i<obj.length;i++)
				clone[i-1]=obj[i];
			p=new Combination(clone);
			currList=p.next();
		}
		n=0;
	}
	public Object[] next() {
		if (obj.length==1&&n==0) {
			Object[] out= {first};
			n++;
			return out;
		}
		if (obj.length>1&&this.hasNext()) {
			Object[] out=new Object[obj.length];
			int i;
			for (i=0;i<n&&i<currList.length;i++) {
				out[i]=currList[i];
			}
			out[n]=first;
			for (i=n+1;i<out.length;i++)
				out[i]=currList[i-1];
			if (n==currList.length) {
				n=0;
				currList=p.next();
			}
			else
				n++;
			return out;
		}
		return null;
	}
	public boolean hasNext() {
		return n==0&&currList!=null||
				n==0&&obj.length==1
				||(obj.length!=1&&(n<obj.length||p.hasNext())&&currList!=null);
	}
	public static void main(String args[]) {
		String[] s={"0","1","2","3"};
		Combination c=new Combination(s);
		while (c.hasNext()) {
			for (Object o:c.next()) {
				System.out.print(o);
			}
			System.out.println();
		}
	}
}
