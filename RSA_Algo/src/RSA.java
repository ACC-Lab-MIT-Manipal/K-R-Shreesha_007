import java.math.BigInteger;
import java.util.*;
public class RSA {
	int gcd(int m,int n)
	{
		if(m==0)
			return n;
		return gcd(n%m,m);
	}
	void rsa(int p,int q)
	{
		int n = p*q;int e,d=0;
		int totient = (p-1)*(q-1);
		for(e=2;e<totient;e++)
		{
			if(gcd(e,totient)==1)
					break;
		}
		 System.out.println("the value of e = " + e);
	        for(int i=0;i<totient;i++)
	        {
	        	if((e*i)%totient==1)
	        	{
	        		d = i;break;
	        	}
	        	d = -1; //no inverse exist
	        }
	        System.out.println("the value of d = " + d);
	        System.out.println("Enter msg:");
	        Scanner s = new Scanner(System.in);
	        int msg = s.nextInt();
	        int c = ((int)Math.pow(msg, e))%n;
	        System.out.println("Encrypted message is : " + c);
	        BigInteger N = BigInteger.valueOf(n);
	        
	        // converting float value of c to BigInteger
	        BigInteger C = BigInteger.valueOf(c);
	        BigInteger msgback = (C.pow(d)).mod(N);
	        System.out.println("Decrypted message is : "
	                           + msgback);
	       
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RSA r = new RSA();
		r.rsa(3, 7);
	}

}
