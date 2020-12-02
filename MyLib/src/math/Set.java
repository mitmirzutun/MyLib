package math;
import java.util.ArrayList;
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
	public Object get(int index) {
		return data.get(index);
	}
	public void add(Object o) {
		if (o!=null)
			data.add(o);
	}
	public String toString() {
		if (data.isEmpty())
			return "empty";
		StringBuilder sb=new StringBuilder();
		sb.append('{');
		sb.append(data.get(0));
		for (int i=1;i<data.size();i++) {
			sb.append(", ");
			sb.append(data.get(0));
		}
		sb.append('}');
		return sb.toString();
	}
}
