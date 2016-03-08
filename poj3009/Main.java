/*
	author : jhonprice
	problem : poj3009
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
	private int ex,ey;
	private int W;
	private int H;
	private int[][] maze;
	private int[] ans;
	public Pro(int w,int h)
	{
		ans = new int[2];
		ans[0] = -1;
		ans[1] = 0;
		W = w;
		H = h;
		maze = new int[H+1][W+1];
	}
	void w_maze(int v,int x,int y)
	{
		maze[x][y] = v;
		if(maze[x][y] == 2)
		{
			sx = x;
			sy = y;
		}
		else if(maze[x][y] == 3)
		{
			ex = x;
			ey = y;
		}
	}
	//待修改
	/*void dfs(int x,int y)
	{
		if(x == ex && y == ey)
		{
			ans[0] = ans[1];
			return;
		}
		for(int i = 0; i < 4 ; i++)
		{
			int nx = x;
			int ny = y;
			int step = 0;
			while(!((nx+dx[i]*step) == ex && (ny+dy[i]*step) == ey) && 0 <= (nx+dx[i]*step) && (nx+dx[i]*step) < H && 0 <= (ny+dy[i]*step) && (ny+dy[i]*step) < W && maze[nx+dx[i]*step][ny+dy[i]*step] != 1)
			{
				step++;
			}
			if(0 > (nx+dx[i]*step) && (nx+dx[i]*step) >= H && 0 > (ny+dy[i]*step) && (ny+dy[i]*step) >= W)
				continue;
			else
			{
				if((nx+dx[i]*step) == ex && (ny+dy[i]*step) == ey)
				{
					nx = nx+dx[i]*step;
					ny = ny+dy[i]*step;
					ans[1]++;
					dfs(nx,ny);
					nx = nx-dx[i]*step;
					ny = ny-dy[i]*step;
				}
				else if(step == 1)
					continue;
				else 
				{
					step--;
					nx = nx+dx[i]*step;
					ny = ny+dy[i]*step;
					maze[nx+dx[i]][ny+dy[i]] = 0; 
					ans[1]++;
					dfs(nx,ny);
					nx = nx-dx[i]*step;
					ny = ny-dy[i]*step;
					maze[nx+dx[i]][ny+dy[i]] = 1;
				}
			}
		}
		return;
	}*/
	void solve()
	{
		dfs(sx,sy);
	}
	int get_ans()
	{
		if(ans[0] > 10)
			return -1;
		else
			return ans[0];
	}
}
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		try
		{
			cin = new Scanner(new FileInputStream("I:\\gitdata\\tz\\poj3009\\data.in"));

		}catch(Exception e){}

		int w = cin.nextInt();
		int h = cin.nextInt();
		while(w !=0 && h!=0)
		{
			Pro ans = new Pro(w,h);

			for(int i = 0; i < h ;i++)
			{
				for(int j = 0; j < w ; j++)
				{
					ans.w_maze(cin.nextInt(),i,j);
				}
			}
			ans.solve();
			System.out.println(ans.get_ans());
			w = cin.nextInt();
			h = cin.nextInt();
		}
	}
}