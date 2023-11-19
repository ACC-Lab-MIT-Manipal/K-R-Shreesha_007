package pollard_rho_dicrete_log;

import java.util.HashMap;

public class Main {
	public static int inv(int a,int n)
	{
		int neg_flag = 0; 
		if(a<0)
		{
			neg_flag = 1;
			a = Math.abs(a);
		}
		for(int i=1;i<n;i++)
		{
			if(a*i%n==1)
				if(neg_flag==0)
					return i;
				else
					return -i;
		}
		System.out.println("Inverse doesnt exist...May get wrong output..!!");
		return -1;
	}
	public static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
	}
	
	public static int polard_rho(int g,int h,int p)
	{
		HashMap<Integer ,int[]> hmap = new HashMap<>();
		hmap.put(1, new int[] {1, 0, 0});
		System.out.println("For i: "+1+"\tx: "+1+"\ta: "+0+"\tb: "+0);
		int flag = 0;
		int i=2;
		int res = 0;
		while(flag!=1) {
			switch(hmap.get(i-1)[0]%3)
			{
			case 0:
				int x = (hmap.get(i-1)[0]*hmap.get(i-1)[0])%p;
				int a = (2*hmap.get(i-1)[1])%p;
				int b = (2*hmap.get(i-1)[2])%p;
				hmap.put(i,new int[] {x,a,b});
				System.out.println("For i: "+i+"\tx: "+x+"\ta: "+a+"\tb: "+b);
				break;
			case 1:
				x = (g*hmap.get(i-1)[0])%p;
				a = (hmap.get(i-1)[1]+1)%p;
				b = (hmap.get(i-1)[2])%p;
				hmap.put(i,new int[] {x,a,b});
				System.out.println("For i: "+i+"\tx: "+x+"\ta: "+a+"\tb: "+b);
				break;
			case 2:
				x = (h*hmap.get(i-1)[0])%p;
				a = (hmap.get(i-1)[1])%p;
				b = (hmap.get(i-1)[2]+1)%p;
				hmap.put(i,new int[] {x,a,b});
				System.out.println("For i: "+i+"\tx: "+x+"\ta: "+a+"\tb: "+b);
				break;			
			}
			if(hmap.get(i)[0]==hmap.get(i/2)[0])
			{
				int num = (hmap.get(i)[1] - hmap.get(i/2)[1]);
				int den = (hmap.get(i/2)[2] - hmap.get(i)[2]);
				num = num/(gcd(num,den));
				den = den/(gcd(num,den));
				
				System.out.println("Num: "+num+" Den: "+den);		 //testing purpose printing values
				System.out.println("Inv: "+inv(Math.abs(den),p-1));  //testing purpose printing values
				
				res = num*inv(den, p-1)%(p-1);
				flag = 1;
				break;
			}
				i++;
		}
		return res<0 ? (res+(p-1))%(p-1):res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("   Polard Rho for Dsicrete Logarithm   ");
		System.out.println("---------------------------------------");
		int ans = polard_rho(3, 37, 101);
		System.out.println("\nResult: "+ans);
		
	}

}
