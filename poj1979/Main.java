/*
	author : jhonprice
	problem : poj1979
	language : java
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Pro
{
	private int[] dx = {1,0,-1,0};
	private int[] dy = {0,1,0,-1};
	private int sx,sy;
	private int W;
	private int H;
	private char[][] maze;
	private int ans;
	public Pro(int w,int h)
	{
		sx = -1;
		sy = -1;
		W = w;
		H = h;
		maze = new char[H][W];
		ans = 0;
	}
	void w_maze(String v,int x)
	{
		for(int j = 0; j < W ; j++)
		{
			maze[x][j] = v.charAt(j);
			if(maze[x][j] == '@')
			{
				sx = x;
				sy = j;
			} 			
		}
	}
	void dfs(int x,int y)
	{
		maze[x][y] = '#';
		ans++;
		for(int i = 0 ; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < H && 0 <= ny && ny < W && maze[nx][ny] != '#')
			{
				dfs(nx,ny);
			}
		}
		return;
	}
	void solve()
	{
		dfs(sx,sy);
	}
	int get_ans()
	{
		return this.ans;
	}
}
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		try
		{
			cin = new Scanner(new FileInputStream("I:\\gitdata\\tz\\poj1979\\data.in"));

		}catch(Exception e){}
		int w = cin.nextInt();
		int h = cin.nextInt();
		while(w != 0 && h != 0)
		{
			Pro ans = new Pro(w,h);
			for(int i = 0 ; i < h; i++)
			{
				ans.w_maze(cin.next(),i);
			}
			ans.solve();
			System.out.println(ans.get_ans());
			w = cin.nextInt();
			h = cin.nextInt();
		}
	}
}