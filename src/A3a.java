import java.util.Scanner;

public class A3a {
	private Stack<Character> s1 = new Stack<Character>();
	private Stack<Character> s2 = new Stack<Character>();	
	public static void main (String args[]) 
	{
		A3a a3 = new A3a();
		a3.run();
	}
	
	public void run() 
	{
		readFile();
	}
	
	public void readFile() 
	{
		Scanner in = new Scanner(System.in);
		String entry;
		System.out.print("Enter a string of characters: ");
		while (in.hasNext()) {
			entry = in.next();
			addToStack(entry);
			reverseStack(entry);
			addToStack(entry);
			print(entry);
			s1.empty();
			s2.empty();
		}
		in.close();
	}
	
	public void addToStack(String input) {
		for(int i = 0; i != input.length(); i++) {
			s1.push(input.charAt(i));
		}
	}
	
	public void reverseStack(String input) {
		for(int i = 0; i < input.length(); i++) {
			s2.push(s1.pop());
		}
	}
	
	public boolean isPall() {
		boolean result = false;
		while(!s1.isEmpty()) {
			if (s1.pop() == s2.pop()) {
				result = true;
			}
			else
				result = false;
		}
		return result;
	}
	
	public void print(String word) {
		if(isPall()) {
			word += " : Yes";
		}
		else
			word += " : No";
		System.out.println(word);
	}
}
