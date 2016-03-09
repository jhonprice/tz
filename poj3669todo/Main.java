/*
	author : jhonprice
	problem : poj3669
	language : java
*/
import java.lang.*;
import java.util.*;
import java.io.*;

class Mars
{
	int first;
	int second;
	int time;
	public Mars(int f,int s,int ti)
	{ 
		first = f;
		second = s;
		time = ti;
	}
}
class Pro
{
	private int[] dx = {1,0,-1,0};
	private int[] dy = {0,1,0,-1};
 	private int INF = 2000;

	private int t; // time

	private int M;
	private int[][] maze;
	private int ans;
	private Mars[] mq;

	public Pro(int m)
	{
		t = -1;
		ans = -1;
		M = m;

		maze = new int[310][310];
		for(int i = 0; i < 310 ; i++)
			Arrays.fill(maze[i],INF);

		mq = new Mars[M];
	}

	void w_mq(int vx,int vy,int vz,int k)
	{
		mq[k] = new Mars(vx,vy,vz);
	}

	void w_maze(int x,int y)
	{
		maze[x][y] = -1;
		for(int i= 0; i < 4 ; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < 300 && 0 <= ny && ny < 300)
			{
				maze[nx][ny] = -1;
			}
		}
	}
	void fire_mq(int t)
	{
		for(int j = 0; j < M; j++)
		{
			if(mq[j].time == t)
			{
				w_maze(mq[j].first,mq[j].second);
				M--;
			}
		}
	}
	void bfs()
	{
		//t = 0; //冗余
		ArrayDeque<Mars> que = new ArrayDeque<Mars>();
		fire_mq(0);
		if(maze[0][0] != -1)
		{
			maze[0][0] = 0;
			t = 0;
			ans = 0;
			if(M == 0)
			{
				ans = t;
				return;
			}
		}
		else
			return;

		while(!(que.isEmpty()))
		{
			Mars mar = que.poll();
			if(M == 0)
			{
				ans = t;
				return;
			}
			for(int i= 0; i < 4 ; i++)
			{
				int nx = mar.first + dx[i];
				int ny = mar.second + dy[i];
				int nt = mar.time + 1;
				fire_mq(nt);
				if(0 <= nx && nx < 300 && 0 <= ny && ny < 300 && maze[nx][ny] != -1 && maze[nx][ny] == INF)
				{	
					que.add(new Mars(nx,ny,nt));
					maze[nx][ny] = nt;
					t = nt;
				}
			} 
		}

	}
	void solve()
	{
		bfs();
		System.out.println(ans);
	}
	int get_ans()
	{
		return ans;
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

		while(cin.hasNextInt())
		{
			int m = cin.nextInt();
			Pro an = new Pro(m);
			for(int i = 0; i < m; i++)
				an.w_mq(cin.nextInt(),cin.nextInt(),cin.nextInt(),i);
			an.solve();
		}
	}
}