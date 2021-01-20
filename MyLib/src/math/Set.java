package math;
import java.util.ArrayList;
import java.util.Iterator;

import exceptions.NoElementInSetException;
public class Set {
	private ArrayList<Object> data;
	public Set(Object...objects) {
		data=new ArrayList<Object>();
		for (Object o:objects) {
			if (o!=null) {
				data.add(o);
			}
		}
	}
	private Set(ArrayList<Object> data) {
		this.data=new ArrayList<Object>(data);
	}
	public Object get(int index) {
		return data.get(index);
	}
	public void add(Object o) {
		add(data.size(),o);
	}
	public void add(int index, Object o) {
		if (o!=null) {
			data.add(index,o);
		}
	}
	public Object remove(int index) {
		if (data.size()==0)
			throw new NoElementInSetException();
		return data.remove(index);
	}
	public int size() {
		return data.size();
	}
	public String toString() {
		if (data.isEmpty())
			return "empty";
		StringBuilder sb=new StringBuilder();
		sb.append('{');
		sb.append(data.get(0));
		for (int i=1;i<data.size();i++) {
			sb.append(", ");
			sb.append(data.get(i));
		}
		sb.append('}');
		return sb.toString();
	}
	public Set clone() {
		return new Set(this.data);
	}
	public static void main(String...args) {
		Set set1=new Set("1","2","3","4","5"),set2=new Set(set1);
		System.out.println(set2);
	}
}
