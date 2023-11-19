import java.util.HashMap;
import java.util.*;

public class MainBaby {
	public static int powInv(int n,int q)
	{
		n = n%q;
		for(int i=1;i<q;i++)
		{
			if(n%i==1)
				return i;
		}
		return -1;
	}
	public static int fastExpo(int a,int pow,int q)
	{
		int y = 1;
		while(pow>0)
		{
			if((pow&1) == 1)
			{
				y = (y*a)%q;
			}
			a = (a*a)%q;
			pow = pow>>1;
		}
		return y;
	}
	public static int baby_gaint_step(int base, int target, int p)
	{
		int m = (int)Math.floor(p);
		int g = powInv(base, p)%p;
		// baby step part
		HashMap<Integer, Integer> babystep = new HashMap<>();
		for(int i=0;i<m;i++)
		{
			int val = fastExpo(base, i, p);
			babystep.put(val, i);
		}
		// giant step part
		for(int i=0;i<m;i++)
		{
			int val = (target*fastExpo(g, m*i, p))%p;
			if(babystep.containsKey(val))
				return m*i + babystep.get(val);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter base: ");
		int base = s.nextInt();
		System.out.println("Enter target: ");
		int target = s.nextInt();
		System.out.println("Enter prime: ");
		int p = s.nextInt();
		int res = baby_gaint_step(base, target, p);
		if(res==-1)
			System.out.println("No solution found");
		else
			System.out.println(res);
		
	}

}
