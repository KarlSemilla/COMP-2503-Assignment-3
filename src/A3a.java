import java.io.*;

public class A3a {
	private Stack<Character> s1 = new Stack<Character>();
	private Stack<Character> s2 = new Stack<Character>();	
	String word;
	
	public static void main (String args[]) throws IOException
	{
		A3a a3 = new A3a();
		a3.run();
	}
	
	public void run() throws IOException
	{
		readFile();
	}
	
	public void readFile() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> tmp = new Stack<Character>();
		char ent;
		int val;
		System.out.print("Enter a string of characters: ");
		while ((val = in.read()) != -1) {
			ent = (char) val;
			if(!Character.isWhitespace(ent)){
				s1.push(ent);
				tmp.push(ent);
			}
			else 
				in.skip(1);
		}
		reverseStack(tmp);
		print(isPall());
		in.close();
	}
	
	public void reverseStack(Stack<Character> tmp) {
		int size = s1.size();
		for(int i = 0; i < size; i++) {
			s2.push(tmp.pop());
		}
	}
	
	public boolean isPall() {
		boolean result = false;
		boolean exit = false;
		while(!s1.isEmpty() && exit != true) {
			if (s1.peek() == s2.peek()) {
				result = true;
				s2.pop();
			}
			else {
				result = false;
				exit = true;
			}
		}
		return result;
	}
	
	public void print(boolean result) {
		if(!s1.isEmpty()) {
			word += s1.pop();
		}
		else if(s1.isEmpty() && result == true) {
			word += " : Yes";
			System.out.println(word);
		}
		else if(s1.isEmpty() && result == false) {
			word += " : No";
			System.out.println(word);
		}
	}
}
