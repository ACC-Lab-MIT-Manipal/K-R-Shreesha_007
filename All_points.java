import java.util.*;

public class All_points {
	
	public static List<int[]> find_All_Points(int p, int a, int b)
	{
		List<int[]> all_points = new ArrayList<>();
		Map<Integer,List<Integer>> hmap = new HashMap<>();
		
		for(int y=0;y<p;y++)
		{
			int LHS = (y*y)%p;
			hmap.putIfAbsent(LHS, new ArrayList<>());
			hmap.get(LHS).add(y);
		}
		
		for(int x=0;x<p;x++)
		{
			int RHS = ((x*x*x)+(a*x)+b)%p;
			if(hmap.containsKey(RHS)) {
				List<Integer> points = hmap.get(RHS);
				for(int i : points)
					all_points.add(new int[] {x, i});
			}
			
		}
		return all_points;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Ep(a,b):\n\t P: ");
		int p = s.nextInt();
		System.out.print("\t A: ");
		int a = s.nextInt();
		System.out.print("\t B: ");
		int b = s.nextInt();
		String text = String.format("All points on the given elliptic curve E%d(%d,%d) are: ",p,a,b);
		System.out.println(text);
		List<int []> all_points = find_All_Points(p, a, b);
		for(int [] points : all_points)
			System.out.println(Arrays.toString(points));
	}

}
