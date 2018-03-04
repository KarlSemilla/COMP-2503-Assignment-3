import java.util.Scanner;
public class A3b2 {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	int carry = 0;
	
	public static void main(String args[]) 
	{
		A3b2 a3 = new A3b2();
		a3.run();
	}
	
	public void run() {
		readFile();
	}
	
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
			//print(calcNum());
		}
		in.close();
	}
	
	public void add(String[] numArr) {
		boolean next = false;
		for(int i = 0; i < numArr.length; i++) {
			if(!numArr[i].equals(" ") && next != true) {
				s1.push(Integer.parseInt(numArr[i]));
				System.out.println(s1.pop());
				}
			else if(numArr[i].equals(" ")) {
				next = true;
			}
			else if(next == true) {
				s2.push(Integer.parseInt(numArr[i]));
				System.out.println(s2.pop());
			}
		}
	}
	
	public int calcNum() {
		int num = s1.pop() + s2.pop();
		if (carry == 1) {
			num += 1;
			carry = 0;
		}
		if (num < 10) {
			carry = 1;
			num -= 10;
		}
		return num;
	}
	
	public void print(int num) {
		System.out.println(num);
	}
}