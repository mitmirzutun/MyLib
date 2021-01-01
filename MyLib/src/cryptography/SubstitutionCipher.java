package cryptography;

public class SubstitutionCipher {
	private char[] encryptKey,decryptKey;
	public SubstitutionCipher(char[] key) {
		if (key.length!=26) {
			throw new exceptions.InvalidEncryptionKeyLength("Expected 26 chars in key. Got "+key.length);
		}
		boolean[] keyChecked=new boolean[26];
		for (int i=0;i<26;i++) {
			key[i]=Character.toUpperCase(key[i]);
			keyChecked[i]=false;
		}
		for (char c:key) {
			if (c<'A'||c>'Z')
				throw new exceptions.InvalidEncryptionKeyLength("Expected character. Got "+c);
			if (keyChecked[c-'A'])
				throw new exceptions.InvalidEncryptionKeyLength("Key duplicate found: "+c);
			keyChecked[c-'A']=true;
		}
		this.encryptKey=key.clone();
		this.decryptKey=new char[26];
		for (int i=0;i<26;i++) {
			this.decryptKey[key[i]-'A']=(char)(i+'A');
		}
	}
	public SubstitutionCipher(String s) {
		this(s.toCharArray());
	}
	public String encrypt(String s) {
		StringBuilder sb=new StringBuilder(s.length());
		for (char c:s.toUpperCase().toCharArray()) {
			if (c>='A'&&c<='Z')
				sb.append(this.encryptKey[c-'A']);
			else
				sb.append(c);
		}
		return sb.toString();
	}
	public String decrypt(String s) {
		StringBuilder sb=new StringBuilder(s.length());
		for (char c:s.toUpperCase().toCharArray()) {
			if (c>='A'&&c<='Z')
				sb.append(this.decryptKey[c-'A']);
			else
				sb.append(c);
		}
		return sb.toString();
	}
	public static void main(String...args) {
		SubstitutionCipher sc=new SubstitutionCipher("ZEBRASCDFGHIJKLMNOPQTUVWXY");
		System.out.println(sc.encrypt("flee at once. we are discovered!"));
		System.out.println(sc.decrypt("SIAA ZQ LKBA. VA ZOA RFPBLUAOAR!"));
	}
}
