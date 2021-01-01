package cryptography;

public class CaesarCipher {
	private long shift;
	public CaesarCipher(int shift) {
		this.shift=math.MathOps.mod(shift,26);
	}
	public String encrypt(String s) {
		StringBuilder sb=new StringBuilder(s.length());
		for (char c:s.toUpperCase().toCharArray()) {
			if (c>='A'&&c<='Z') {
				sb.append((char)(math.MathOps.mod(c-'A'+shift, 26)+'A'));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public String decrypt(String s) {
		StringBuilder sb=new StringBuilder(s.length());
		for (char c:s.toUpperCase().toCharArray()) {
			if (c>='A'&&c<='Z') {
				sb.append((char)(math.MathOps.mod(c-'A'-shift, 26)+'A'));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public static void main(String...args) {
		CaesarCipher cc=new CaesarCipher(15);
		System.out.println(cc.encrypt("flee at once. we are discovered!"));
		System.out.println(cc.decrypt("UATT PI DCRT. LT PGT SXHRDKTGTS!"));
	}
}
