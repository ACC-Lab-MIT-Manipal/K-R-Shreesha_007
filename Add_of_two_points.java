import java.util.*;

public class Add_of_two_points {
	public static int modInverse(int a,int m)
	{
		a = a % m;	// a should be in range of m
		for(int x = 1; x<m; x++) 
		{
			if((a*x)%m==1)		
				return x;
		}
		return -1;		//if no inverse
	}
	public static int make_pos(int z, int p)
	{
		return z < 0 ? z + p : z; 
		
	}
	public static int[] add_points(int[] P, int[] Q,int p,int a)
	{
		int [] res = new int[2];
		int x,y,lamda;
		if(Arrays.equals(P, Q))
		{
			y = 3*(P[0]*P[0])+a;
			x = 2*P[1];
		}
		else {
			y = Q[1] - P[1];
			x = Q[0] - P[0];
		}
		int inv_x = modInverse(x,p);
			lamda = ((y%p)*inv_x)%p;
		
		int x3 = (lamda*lamda - P[0] - Q[0])%p;
		int y3 = (lamda*(P[0]-x3) - P[1])%p;
		
		return new int[] {make_pos(x3, p),make_pos(y3, p)};
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int[] P = new int[2];
		int[] Q = new int[2];
		System.out.print("Enter Ep(a,b):\n\t P: ");
		int p = s.nextInt();
		System.out.print("\t A: ");
		int a = s.nextInt();
		System.out.print("\t B: ");
		int b = s.nextInt();
		System.out.println("Enter P :");
		System.out.print("\t x: ");
		P[0] = s.nextInt();
		System.out.print("\t y: ");
		P[1] = s.nextInt();
		System.out.println("Enter Q :");
		System.out.print("\t x: ");
		Q[0] = s.nextInt();
		System.out.print("\t y: ");
		Q[1] = s.nextInt();
		System.out.println("Entered two points P: "+Arrays.toString(P)+" Q: "+Arrays.toString(Q));
		String text = String.format("Adding two points on the given elliptic curve E%d(%d,%d) are: ",p,a,b);
		System.out.println(text);
		int[] res = add_points(P, Q, p, a);
		System.out.println("Result: "+Arrays.toString(res));
	}

}
