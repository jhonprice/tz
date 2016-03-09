/*
	author : jhonprice
	problem : poj3009
	language : java
	note: 注意还原状态值
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
		ans[0] = 9999;
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
	void dfs(int x,int y)
	{
		if(ans[1] > 10)    //注意剪植
			return;
		if(x == ex && y == ey)
		{
			if(ans[0] > ans[1])
				ans[0] = ans[1];
			return;
		}
		for(int i = 0; i < 4 ; i++)
		{
			int nx = x;
			int ny = y;
			int step = 1;

			while(!(nx + dx[i] * step == ex && ny + dy[i] * step == ey ) && 0 <= (nx + dx[i] * step) && (nx + dx[i] * step) < H && 
				0 <= (ny + dy[i] * step) && (ny + dy[i] * step) < W && maze[nx + dx[i] * step][ny + dy[i] * step] != 1)
			{
				step++;
			}
			if(nx + dx[i] * step == ex && ny + dy[i] * step == ey)
			{
				ans[1]++;
				dfs(nx+dx[i]*step,ny+dy[i]*step);
				ans[1]--;
			}
			else if (!(0 <= (nx + dx[i] * step) && (nx + dx[i] * step) < H && 0 <= (ny + dy[i] * step) && (ny + dy[i] * step) < W)) 
			{
				continue;
			}
			else if(maze[nx + dx[i] * step][ny + dy[i] * step] == 1)
			{
				if(step == 1)
					continue;
				else
				{
					ans[1]++;
					maze[nx + dx[i] * step][ny + dy[i] * step] = 0;
					dfs(nx+dx[i]*(step-1),ny+dy[i]*(step-1));
					ans[1]--;
					maze[nx + dx[i] * step][ny + dy[i] * step] = 1;
				}
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
			cin = new Scanner(new FileInputStream(".\\data.in"));

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