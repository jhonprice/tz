import java.util.*;
public class binary_search
{
	public static void main(String[] args)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		for(int i = 0;i < 9; i++)
		{
			c.add(i);
		}
		System.out.println(Collections.binarySearch(c,0));
	}
}