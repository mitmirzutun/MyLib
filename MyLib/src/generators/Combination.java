package generators;

import math.Set;

public class Combination extends Generator {
	private Object first;
	private Set set,curSet;
	private Combination p;
	private int n;
	public Combination(Object[] obj) {
		this(new Set(obj));
	}
	public Combination(Set set) {
		super(true);
		if (set.size()==0)
			return;
		n=0;
		this.set=set.clone();
		Set tmp=set.clone();
		first=tmp.remove(0);
		p=new Combination(tmp);
		curSet=p.next();
	}
	public Set next() {
		return null;
	}
	public boolean hasNext() {
		return false;
	}
	public static void main(String args[]) {
		Object Array[]= {"0","1","2"};
		Set set=new Set(Array);
		System.out.println(set);
	}
}
