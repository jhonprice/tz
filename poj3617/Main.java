/*
	author : default
	problem : poj3617
	language : java
*/

import java.util.*;
import java.io.*;

class Pro
{
	private int N;
	private char[] S;
	ArrayDeque<Character> T;
	public Pro(int n)
	{
		N = n;
		S = new char[n];
		T = new ArrayDeque<Character>(); 
	}
	void w_s(String c,int i)
	{
		S[i] = c.charAt(0);
	}
	void solve()
	{
		int a = 0, b = N - 1;
		while(a <= b)
		{
			boolean left = false;
			for(int i = 0 ; a + i <= b; i++)
			{
				if(S[a + i] < S[b - i])
				{
					left = true;
					break;
				}
				else if(S[a + i] > S[b - i])
				{
					left = false;
					break;
				}
			}

			if(left)
				T.add(S[a++]);
			else
				T.add(S[b--]);
		}
	}
	void print_T()
	{
		for(int i = 1 ; !(T.isEmpty()) ; i++)
		{
			System.out.print(T.poll());
			if(i % 80 == 0)
				System.out.println("");
		}
	}

}
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n = cin.nextInt();
			Pro ans = new Pro(n);
			for(int i = 0 ; i < n ; i++)
			{
				ans.w_s(cin.next(),i);
			}
			ans.solve();
			ans.print_T();
		}
	}
}