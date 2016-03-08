/*
	author : default
	problem : poj2386
	language : java
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class Pro
{
	private int Max_M;
	private int Max_N;
	char[][] mp;
	private int ans; 
	public Pro(int n,int m)
	{
		ans=0;
		Max_N = n;
		Max_M = m;
		mp = new char[Max_N][Max_M];
	}
	void w_mp(String v,int x)
	{
		for(int j = 0 ; j < Max_M ; j++)
			this.mp[x][j] = v.charAt(j);
	}
	void dfs(int x,int y)
	{
		mp[x][y] = '.';
		for(int i = -1; i <= 1; i++)
		{
			for(int j = -1;j <= 1; j++ )
			{
				int dx = x + i;
				int dy = y + j;
				if(0 <= dx && dx < Max_N && 0 <= dy && dy < Max_M && mp[dx][dy] == 'W' )
					dfs(dx,dy);
			}
		}
		return;
	}
	void solve()
	{
		for(int i = 0; i < Max_N ;i++)
			for(int j= 0; j < Max_M ;j++)
			{
				if(mp[i][j] == 'W')
				{
					dfs(i,j);
					ans++;
				}
			}
	}
	int get_ans()
	{
		return this.ans;
	}
	void print_mp()
	{
		for(int i = 0;i < Max_N; i++)
		{
			for(int j = 0 ; j < Max_M ; j++)
			{
				System.out.print(mp[i][j]);
			}
			System.out.print("\n");
		}
	}
}
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		try
		{
			cin = new Scanner(new FileInputStream("I:\\gitdata\\tz\\poj2386\\data.in"));
		}catch(Exception e){} 
		while(cin.hasNextInt())
		{
			int n,m;
			n = cin.nextInt();
			m = cin.nextInt();
			Pro ans = new Pro( n , m );
			String s = new String();
			for(int i = 0;i < n; i++)
			{
				s = cin.next();
				ans.w_mp(s,i);
			}
			//ans.print_mp();
			ans.solve();
			System.out.println(ans.get_ans());
		}
	}
}