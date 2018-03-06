/* Karl Semilla
 * COMP 2503 - Assignment 3
 */
import java.util.Scanner;
public class A3b {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	int carry = 0;
	
	public static void main(String args[]) 
	{
		A3b a3 = new A3b();
		a3.run();
	}
	
	public void run() {
		readFile();
		calcNum();
	}
	
	/* Reads the file, puts input to a string array.
	 */
	public void readFile() {
		Scanner in = new Scanner(System.in);
		String num;
		
		while(in.hasNext()) {
			num = in.nextLine();
			String[] numArr = new String[num.length()];
			for(int i = 0; i < num.length(); i++) {
				numArr[i] = num.substring(i, i + 1);
			}
			add(numArr);
			calcNum();
		}
		in.close();
	}
	
	/* Uses the string array passed through to add to both stacks.
	 * Once the whitespace is reached add to next array.
	 * Also prints original numbers.
	 */
	public void add(String[] numArr) {
		boolean next = false;
		for(int i = 0; i < numArr.length; i++) {
			if(!numArr[i].equals(" ") && next != true) {
				System.out.print(numArr[i]);
				s1.push(Integer.parseInt(numArr[i]));
				}
			else if(numArr[i].equals(" ")) {
				next = true;
				System.out.println();
				System.out.print("+ ");
			}
			else if(next == true) {
				System.out.print(numArr[i]);
				int size = (numArr.length - s1.size()) - 1;
					if(size < s1.size()) {
						fillStack(numArr.length - s1.size());
					}
				s2.push(Integer.parseInt(numArr[i]));
			}
		}
		System.out.println();
		System.out.print("= ");
	}
	
	/* Puts zeros into either stack by checking size of stack 1.
	 */
	public void fillStack(int times) {
		while(s1.size() != s2.size() || s2.size() != s1.size()) {
			if(s1.size() <= s2.size()) {
				s1.push(0);
			}
			else if(s2.size() <= s1.size()) {
				s2.push(0);
			}
		}
	}
	
	/* Calculates the sum of the top of each stack.
	 * Adds carries and determines if there is a carry.
	 */
	public void calcNum() {
		while(s1.peek() != null && s2.peek() != null) {
			int num = s1.pop() + s2.pop();
			if (carry == 1) {
				num += 1;
				carry = 0;
			}
			else if(carry == 1 && s1.peek() == null && s2.peek() == null) {
				num = carry;
			}
			if (num > 9) {
				carry = 1;
				num -= 10;
			}
			 System.out.print(num);
		}
		 System.out.println();
	}
}