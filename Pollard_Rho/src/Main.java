import java.util.*;

public class Main {
	
	public static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
			
	}
	
	public static int g_fun(int x,int n)
	{
		return (x*x+1)%n;
	}
	public static int polard_rho(int n,int a,int b)
	{
		int d = 1;
		while(d==1)
		{
			a = g_fun(a,n);
			b = g_fun(g_fun(b,n), n);
			d = gcd(Math.abs(a-b),n);
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
		System.out.println("Enter b:");
		int b = s.nextInt();		
		int x = polard_rho(n,a,b);
		if(x==-1) {
			System.out.println("Polard Rho failed...change the a b values");
			return;
		}
		int y = n/x;
		System.out.println("Factors: "+x+", "+y);
	}

}
