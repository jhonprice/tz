/*
	author : jhonprice
	problem : binary_search
	language ：java 
*/

import java.lang.*;
import java.util.*;
import java.io.*;

class BS
{
	private int[] x;
	public BS(int[] x)
	{
		this.x = x;
	}
	int binary_search(int t,int left,int right)
	{
		int l = left;
		int r = right;
		while(r >= l)
		{
			int i = (l + r) / 2;
			if(this.x[i] == t)
				return i;
			else if(this.x[i] < t)
				l = i + 1;
			else
				r = i - 1;
		}
		return -99999999;
	}
	int[] get_x()
	{
		return this.x;
	} 

}
public class Main
{
	public static void main(String[] args)
	{
		int[] test={1,2,3,4};
		BS a = new BS(test);
		System.out.println(a.binary_search(4,0,3));
	}
}