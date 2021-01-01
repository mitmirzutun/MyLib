package cryptography;

public class VigenereCipher {
	private CaesarCipher cc[];
	public VigenereCipher(String key) {
		this(key.toCharArray());
	}
	public VigenereCipher(char[] key) {
		char[] tmp=new char[key.length];
		int n=0;
		for (char c:key) {
			c=Character.toUpperCase(c);
			if (c>='A'&&c<='Z') {
				tmp[n]=c;
				n++;
			}
		}
		this.cc=new CaesarCipher[n];
		for (int i=0;i<n;i++) {
			this.cc[i]=new CaesarCipher(tmp[i]-'A');
		}
	}
	public String encrypt(String msg) {
		String[] msgParts=this.split(msg);
		for (int i=0;i<msgParts.length;i++)
			msgParts[i]=cc[i].encrypt(msgParts[i]);
		return this.merge(msgParts);
	}
	public String decrypt(String msg) {
		String[] msgParts=this.split(msg);
		for (int i=0;i<msgParts.length;i++)
			msgParts[i]=cc[i].decrypt(msgParts[i]);
		return this.merge(msgParts);
	}
	
	private String[] split(String msg) {
		StringBuilder sb[]= new StringBuilder[cc.length];
		for (int i=0;i<cc.length;i++)
			sb[i]=new StringBuilder();
		for (int i=0;i<msg.length();i++)
			sb[i%cc.length].append(msg.charAt(i));
		String[] s=new String[cc.length];
		for (int i=0;i<cc.length;i++)
			s[i]=sb[i].toString();
		return s;
	}
	private String merge(String[] msgParts) {
		StringBuilder sb=new StringBuilder();
		while (true) {
			try {
				sb.append(msgParts[sb.length()%msgParts.length].charAt(sb.length()/msgParts.length));
			} catch (StringIndexOutOfBoundsException ae) {
				return sb.toString();
			}
		}
	}
	public static void main(String[] args) {
		VigenereCipher vg=new VigenereCipher("XYZ");
		System.out.println(vg.encrypt("Hello World"));
		System.out.println(vg.decrypt("ECKIM TMQIB"));
	}
}
