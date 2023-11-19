import java.util.Arrays;
import java.util.Scanner;

public class ECC {
	public static int inverse(int a,int n)
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
	public static int[] add_points(int[] X,int[] Y,int a,int b,int q)
	{
		int lam;
		if(Arrays.equals(X, Y))
		{
			lam = (((3*X[0]*X[0])+a)*inverse(2*X[1], q))%q;
		}
		else
			lam = ((Y[1]-X[1])*inverse((Y[0]-X[0]), q))%q;  
		
		int x3 = ((lam*lam)-X[0]-Y[0])%q;
		int y3 = (lam*(X[0]-x3)-X[1])%q;
		x3 = x3<0 ? (x3+q)%q : x3;
		y3 = y3<0 ? (y3+q)%q : y3;
		
		return new int[] {x3,y3};
	}
	
	public static int[] addtitive_inv(int[] P,int q)
	{
		return new int[] {P[0],q-P[1]};
	}
	public static int[] multiply_points(int r,int[] X,int a,int b,int q)
	{
		int[] temp = X;
		for(int i=1;i<r;i++)
		{
			temp = add_points(X,temp, a, b, q);
//			System.out.println(Arrays.toString(temp));
		}
		return temp;
	}
	
	public static int[][] encryption(int P[],int r,int[] e1,int[] e2,int a,int b,int q)
	{
		int[] C1 = multiply_points(r, e1, a, b, q);
		int[] temp_c2 = multiply_points(r, e2, a, b, q);
		int[] C2 = add_points(P, temp_c2, a, b, q);
		
		return new int[][] {C1,C2};
	}
	public static int[] decryption(int[] C1,int[] C2,int d,int a,int b,int q)
	{
		int[] temp_c1 = addtitive_inv(C1, q);
		temp_c1 = multiply_points(d, temp_c1, a, b, q);
		int[] result = add_points(C2, temp_c1, a, b, q);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] temp = multiply_points(4, new int[] {2,22}, 2, 3, 67);
//		System.out.println(Arrays.toString(temp));
		//Bob selects e1 and d
		Scanner s = new Scanner(System.in);
		System.out.print("Enter E (a, b, q): ");
		int a = s.nextInt();
		int b = s.nextInt();
		int q = s.nextInt();
		System.out.println("----- Bob side -----");
		System.out.print("Enter e1(x,y): ");
		int[] e1 = new int[2];
		for(int i=0;i<2;i++)
			e1[i] = s.nextInt();
		System.out.print("Enter d: ");
		int d = s.nextInt();
		int[] e2 = multiply_points(d, e1, 2, 3, 67);
		System.out.print("e2(x,y): "+Arrays.toString(e2));
		System.out.printf("\nBob publically announces\n\t E%d(%d,%d)\n\t e1(%d,%d) \n\t e2(%d,%d)\n\n",q,a,b,e1[0],e1[1],e2[0],e2[1]);
		System.out.println("----- Alice side -----");
		System.out.print("Enter P(x,y): ");
		int[] plain_text = new int[2];
		for(int i=0;i<2;i++)
			plain_text[i] = s.nextInt();
		System.out.print("Enter r: ");
		int r = s.nextInt();
		System.out.println("----- Alice Encrypting the msg >>>>");
		int[][] ciphers = encryption(plain_text,r,e1, e2, 2, 3, 67);
		System.out.println("Ciphers C1 & C2: "+Arrays.deepToString(ciphers));
		System.out.println("----- Bob Decrypting the msg >>>>");
		int[] decrypted_msg = decryption(ciphers[0], ciphers[1], d, 2, 3, 67);
		System.out.println("Decrypted msg: "+Arrays.toString(decrypted_msg));
	}

}
