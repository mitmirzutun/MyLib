package generators;
public abstract class Generator {
	private boolean ends; 
	public Generator(boolean ends) {
		this.ends=ends;
	}
	public abstract Object next();
	public abstract boolean hasNext();
	public boolean isInfinite() {
		return !ends;
	}
}
