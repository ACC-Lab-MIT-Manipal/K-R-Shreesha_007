import java.util.*;
public class CaesarCipher { 
	
	String encrypt(String plaintext,int offset)
	{
		StringBuilder result = new StringBuilder();
		for(char p : plaintext.toCharArray())
		{
			char X = ' ';
			if(Character.isUpperCase(p))
				X = 'A';
			else if(Character.isLowerCase(p))
				X = 'a';
			if(p!= ' ')
			{
				int orgPos = p - X;
				int updatedPos = (orgPos+offset)%26;
				char updatedChar = (char)(X + updatedPos);
				result.append(updatedChar);
			}
			else
				result.append(" ");
		}
		return result.toString();
	}
	
	String decrypt(String ciphertext,int offset)
	{
		return encrypt(ciphertext, 26 - (offset%26));
	}
	void cryptanalysis(String cipertext)
	{
		for(int i=0;i<26;i++)
		{
			System.out.println(encrypt(cipertext, i));
		}
	}
	public static void main(String[] args) {

		CaesarCipher c = new CaesarCipher();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter plaintext : ");
		String plaintext = s.nextLine();
		System.out.println("Enter offset: ");
		int offset = s.nextInt();
		String cipher = c.encrypt(plaintext, offset);
		System.out.println("Cipher text: \n"+cipher);
		String decrypted_msg = c.decrypt(cipher, offset);
		System.out.println("After Decryption: \n"+decrypted_msg+"\n");
		System.out.println("::CRYPTANALYSIS::");
		System.out.println("=========================");
		System.out.println("Possible Plain Texts are: ");
		System.out.println("=========================");
		c.cryptanalysis(cipher);
	}

}
