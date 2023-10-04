import java.util.*;

public class Main {
	
	public static boolean check_perfect_sq(int p)
	{
		if(Math.ceil(Math.sqrt(p))==Math.floor(Math.sqrt(p)))
			return true;
		return false;
	}
	
	public static int[] fermat_diff_of_squares(int N)
	{
		int x = (int) Math.ceil(Math.sqrt(N));
		int t = 2*(x)+1;
		int d = (x*x) - N;
		System.out.println("d: "+d+" t: "+t);
		
		while(!check_perfect_sq(d))
		{
			d = d +t;
			t = t+2;
			System.out.println("d: "+d+" t: "+t);
		}
		int p = (int)Math.sqrt(d+N);
		int q = (int)Math.sqrt(d);
		System.out.println("X: "+p+" Y: "+q);
		return new int[] {p+q,p-q};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number N: ");
		int N = s.nextInt();
		int[] res = fermat_diff_of_squares(N);
		System.out.println("Two factors are: "+Arrays.toString(res));
	}

}
