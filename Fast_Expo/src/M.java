import java.util.*;
public class M {
	
	public void fast_expo(int a,int pow,int mod)
	{
		int y = 1;
		while(pow>0)
		{
			int last_bit = (pow&1);
			if(last_bit==0)
			{
				a = (a*a)%mod;
			}
			else
			{
				y = (y*a)%mod;
				a = (a*a)%mod;
			}
			pow = pow>>1;
		}
		System.out.println("Ans:  "+y);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M m = new M();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a: ");
		int a = s.nextInt();
		System.out.println("Enter power: ");
		int pow = s.nextInt();
		System.out.println("Enter mod: ");
		int mod = s.nextInt();
		m.fast_expo(a, pow, mod);
	}

}
