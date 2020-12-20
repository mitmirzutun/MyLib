package test.generators;

public abstract class Generator {
	public abstract Object generate();
	public Object next() {
		try {
			return generate();
		} catch (exceptions.EndOfGeneratorException eoge) {
			return null;
		}
	}
}
