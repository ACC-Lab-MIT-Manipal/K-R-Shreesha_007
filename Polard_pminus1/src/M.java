import java.util.*;

public class M {
	
	public static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
			
	}
	
	public static int fact(int x)
	{
		int p=1;
		for(int i=1;i<=x;i++) {
			p = p*i;
		}
		return p;
	}
	public static int polard_p_minus_1(int n,int a)
	{
		int d = 1;int k=0;
		while(d==1)
		{
			
			d = gcd((int)(Math.pow(a, fact(++k))-1)%n,n);
		}
		if(d<n)
			return d;
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = s.nextInt();
		System.out.println("Enter a:");
		int a = s.nextInt();		
		int x = polard_p_minus_1(n,a);
		if(x==-1) {
			System.out.println("Polard p-1 failed...change the a values");
			return;
		}
		int y = n/x;
		System.out.println("Factors: "+x+", "+y);
	}

}
