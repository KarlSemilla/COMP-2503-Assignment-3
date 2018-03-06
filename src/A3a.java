/* Karl Semilla
 * COMP 2503 - Assignment 3
 */
import java.io.*;

public class A3a {
	private Stack<Character> s1 = new Stack<Character>();//Reversed word stack
	private Stack<Character> s2 = new Stack<Character>();	//Original word stack.
	
	public static void main (String args[]) throws IOException
	{
		A3a a3 = new A3a();
		a3.run();
	}
	
	public void run() throws IOException
	{
		readFile();
		print(isPall());
	}
	/* This method reads the file character by character, while pushing them to stack 1.
	 * If there is a white space, line-break or carriage-return, it will call the reverseStack method.
	 */
	public void readFile() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> tmp = new Stack<Character>();//Temporary stack to reverse.
		char curr; //Current character
		int val; //Current value in integer form.
		while ((val = in.read()) != -1) { 
			curr = (char) val; //Casts integer to char.
			if(!Character.isWhitespace(curr)){
				s1.push(curr);
				tmp.push(curr);
			}
			else if(val == 10 || val == 13) {
				reverseStack(tmp);
				print(isPall());
			}
			else
				in.skip(1);
		}
		
		reverseStack(tmp);
		in.close();
	}
	
	/* Reverses the temporary stack by pushing all contents to the stack 2.
	 */
	public void reverseStack(Stack<Character> tmp) {
		while(tmp.peek() != null){
			s2.push(tmp.pop());
		}
	}
	
	/* Returns a boolean result depending on if top of the stacks are equal.
	 * Repeats until both stacks are empty.
	 */
	public boolean isPall() {
		boolean check = true;
			while (!s1.isEmpty()) {
			if (s1.peek() == s2.peek() && s2.peek() == s1.peek()) {
				System.out.print(s2.pop());
			}
			else {
				System.out.print(s2.pop());
				check = false;
			}
			s1.pop();
		}
		return check;
	}
	
	/* Prints the yes or no to the end of the word depending on result of
	 * the isPall method.
	 */
	public void print(boolean result) {
		String word = "";
		if(result == true) {
			word = " : Yes";
		}
		else if(result == false) {
			word = " : No";
		}
		System.out.print(word);
		System.out.println();
	}
}
