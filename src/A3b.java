import java.util.Scanner;
public class A3b {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public static void main(String args[]) 
	{
		A3b a3 = new A3b();
		a3.run();
	}
	
	public void run() {
		readFile();
	}
	
	public void readFile() {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			s1.push(in.nextInt());
			s2.push(in.nextInt());
			print(calcNum());
		}
		in.close();
	}
	
	public int calcNum() {
		int i = s1.pop() + s2.pop();
		return i;
	}
	
	public void print(int num) {
		System.out.println(num);
	}
}