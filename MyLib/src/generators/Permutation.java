package generators;

import exceptions.EndOfGeneratorException;
import exceptions.NoElementInSetException;
import math.Set;

public class Permutation extends Generator {
	private int n,baseSetLength;
	private Object first;
	private Permutation p;
	private Set currentSet;
	public Permutation(Set s) {
		if (s.size()==0)
			throw new NoElementInSetException();
		n=0;
		first=s.get(0);
		baseSetLength=s.size();
		if (s.size()>1) {
			s.remove(0);
			p=new Permutation(s);
			currentSet=p.generate();
		} else {
			
		}
	}
	public Set generate() {
		if (currentSet==null&&baseSetLength==n)
			throw new EndOfGeneratorException();
		if (baseSetLength==n) {
			n=0;
			currentSet=p.generate();
		}
		if (baseSetLength==1) {
			n++;
			return new Set(first);
		}
		Set tmp=currentSet.clone();
		tmp.add(n,first);
		n++;
		return tmp;
	}
	public static void main(String...args) {
		Permutation p=new Permutation(new Set("1","2","3","4"));
		while (true) {
			try {
				System.out.println(p.generate());
			} catch(EndOfGeneratorException e) {
				break;
			}
		}
	}
}
