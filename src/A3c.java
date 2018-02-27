import java.util.Scanner;
public class A3c {
	private Queue q1 = new Queue();
	
	public static void main (String args[]) 
	{
		A3c a3 = new A3c();
		a3.run();
	}
	
	public void run() 
	{
		readFile();
	}
	
	public void readFile() 
	{
		String input;
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			input = in.nextLine();
		}
		in.close();
	}
}
