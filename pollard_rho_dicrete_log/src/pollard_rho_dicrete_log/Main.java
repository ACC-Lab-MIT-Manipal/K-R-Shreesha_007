package pollard_rho_dicrete_log;

import java.util.HashMap;

public class Main {
	public static int inv(int a,int n)
	{
		a = a%n;
		for(int i=1;i<n;i++)
		{
			if(a*i%n==1)
				return i;
		}
		return -1;
	}
	
	public static int polard_rho(int g,int h,int p)
	{
		HashMap<Integer ,int[]> hmap = new HashMap<>();
		hmap.put(1, new int[] {1, 0, 0});
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
				break;
			case 1:
				x = (g*hmap.get(i-1)[0])%p;
				a = (hmap.get(i-1)[1]+1)%p;
				b = (hmap.get(i-1)[2])%p;
				hmap.put(i,new int[] {x,a,b});
				break;
			case 2:
				x = (h*hmap.get(i-1)[0])%p;
				a = (hmap.get(i-1)[1])%p;
				b = (hmap.get(i-1)[2]+1)%p;
				hmap.put(i,new int[] {x,a,b});
				break;
			}
			if(hmap.get(i)[0]==hmap.get(i/2)[0])
			{
				int num = (hmap.get(i)[1] - hmap.get(i/2)[1]);
				int den = (hmap.get(i/2)[2] - hmap.get(i)[1]);
				if(inv(den, p-1)==-1)
					return -1;
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
		
		int ans = polard_rho(3, 37, 101);
		System.out.println(ans);
		
	}

}
