import java.io.*; 
import java.util.*; 
public class Main
{ 
	public static void main(String args[])
	{ 
		Scanner cin = new Scanner(System.in); 
		try
		{
			cin = new Scanner(new FileInputStream("F:\\gitdate\\tz\\try\\data.in"));
		}catch(Exception e){} 
		int a, b; 
		while (cin.hasNext())
		{ 
			a = cin.nextInt(); 
			b = cin.nextInt(); 
			System.out.println(a + b); 
		} 
	} 
}

