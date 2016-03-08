import java.util.*;
public class queue
{
	public static void main(String[] args)
	{
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(1);
		q.add(2);
		System.out.println(q.poll());

	}
}