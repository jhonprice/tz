/*
	author : default
	problem : poj1852
	language : java 
*/
import java.lang.*;
import java.io.*;
import java.util.*;

class Pro
{
	//asdasda
	private int L;
	private int N;
	private int[] x;
	private int Min_T;
	private int Max_T;
	public Pro(int L,int N)
	{
		this.L = L;
		this.N = N;
		this.Min_T = 0;
		this.Max_T = 0;
		x = new int[N+1];
	} 
	void w_x(int v,int i)
	{
		this.x[i]=v;
	}
	void solve()
	{
		for(int i = 0; i < N; i++)
		{
			this.Min_T = Math.max(Min_T , Math.min(this.x[i] , this.L-this.x[i]) );   //min(找到离杆子某一段最近的距离) max(找一群点中到任意一段的最小距离)
			this.Max_T = Math.max(Max_T , Math.max(this.x[i] , this.L-this.x[i]) );
		}
	}
	int get_Min_T()
	{
		return this.Min_T;
	}
	int get_Max_T()
	{
		return this.Max_T;
	}
}
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int C = cin.nextInt();
		while(C > 0)
		{
			int l = cin.nextInt();
			int n = cin.nextInt();
			Pro ans = new Pro(l,n);
			for(int i = 0; i < n; i++)
			{
				ans.w_x(cin.nextInt(),i);
			}
			ans.solve();
			System.out.println(ans.get_Min_T() + " " + ans.get_Max_T() );
			C--;
		}
	}
}
