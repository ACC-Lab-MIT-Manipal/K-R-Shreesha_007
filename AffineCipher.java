import java.util.Scanner;
  
public class AffineCipher {
	int a = 17, b = 20;
	String encrypt(String plaintext)
	{
		StringBuilder result = new StringBuilder();
		for(char p : plaintext.toCharArray())
		{
			if(p!= ' ')
			{
				char updatedChar = (char) ((((a * (p - 'A')) + b) % 26) + 'A');
				result.append(updatedChar);
			}
			else
				result.append(" ");
		}
		return result.toString();
	}
	String decrypt(String ciphertext)
	{
		StringBuilder result = new StringBuilder();
		int a_inv = 0, flag=0;
		for(int i=0;i<26;i++)
		{
			flag = (a*i)%26;
			if(flag==1)
			{
				a_inv = i;
			}
		}
		for(char p : ciphertext.toCharArray())
		{
			if(p!= ' ')
			{
				char updatedChar = (char) (((a_inv *
                        ((p + 'A' - b)) % 26)) + 'A');
				result.append(updatedChar);
			}
			else
				result.append(" ");
		}
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AffineCipher c = new AffineCipher();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter plaintext : ");
		String plaintext = s.nextLine();
		String cipher = c.encrypt(plaintext);
		System.out.println("Cipher text: \n"+cipher);
		String decrypted_msg = c.decrypt(cipher);
		System.out.println("After Decryption: \n"+decrypted_msg+"\n");
	}

}
