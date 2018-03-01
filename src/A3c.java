import java.util.Scanner;
public class A3c {
	private Queue<String> q1 = new Queue<String>();
	
	public static void main (String args[]) 
	{
		A3c a3 = new A3c();
		a3.run();
	}
	
	public void run() 
	{
		readFile();
		transac();
	}
	
	public void readFile() 
	{
		String input;
		String[] split;
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			input = in.nextLine();
			split = input.split(" ");
			queue(split);
			transac();
			}
		in.close();
	}
	
	public void queue(String add[]) 
	{
		for(int i = 0; i < 3; i++) {
			q1.enqueue(add[i]);
		}
	}
	
	public void transac() 
	{
		String type = q1.dequeue();
		int sum = 0;
		while(!q1.isEmpty()) {
			if(q1.dequeue().equalsIgnoreCase("Buy")) {
				sum = -(Integer.parseInt(q1.dequeue()) * Integer.parseInt(q1.dequeue()));
			}
			else {
				sum = Integer.parseInt(q1.dequeue()) * Integer.parseInt(q1.dequeue());
			}
			System.out.println("This will result in a capital gain: $" + sum);	
		}
	}
}
