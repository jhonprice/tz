/*
	author : default
	problem : dfs
	language : java
*/

import java.lang.*;
import java.util.*;
import java.io.*;
class pair
{
	int first;
	int second;
	public pair(int f,int s)
	{
		first = f;
		second = s;
	}
}
class Pro
{
	public int INF=10000000;
	private int[] dx = {1,0,-1,0};
	private int[] dy = {0,1,0,-1};
	private int N;
	private int M;
	private char[][] maze;
	private int[][] d;
	private int sx, sy;
	private int gx, gy;

	public Pro(int n, int m)
	{
		N = n;
		M = m;
		d = new int[N][M];
		maze =new char[N][M];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				d[i][j] = INF;
			}
		}
	}
	void w_maze(String v, int x)
	{
		for(int j = 0; j < M;j++)
		{
			maze[x][j] = v.charAt(j);
		}
	}
	int dfs()
	{
		ArrayDeque<pair> que = new ArrayDeque<pair>();
		que.add(new pair(sx,sy));
		d[sx][sy] = 0;
		while(que.isEmpty())
		{
			pair p = que.getFirst();
			que.pop();
			if(p.first == gx && p.second == gy)
				break;
			for(int i = 0; i < 4 ; i++)
			{
				int nx = p.first + dx[i];
				int ny = p.second + dy[i];

				if(0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] != '#' && d[nx][ny] == INF)
				{
					que.push(new pair(nx,ny));
					d[nx][ny] = d[p.first][p.second] + 1;
				}
			}
		}
		return d[gx][gy];

	}
	int solve()
	{
		int ans = dfs();
		System.out.println(ans);
		return ans;
	}
}
public class Main
{
	public static void main(String[] args)
	{

	}
}