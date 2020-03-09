package array;

import java.util.Stack;

public class StackGetMin {

	Stack<Integer> s;
	Integer minEle;
	public StackGetMin() {
		s = new Stack<Integer>();
	}
	
	public static void main(String[] args) {
		StackGetMin s = new StackGetMin();
		s.push(3);
		s.push(5);
		s.getMin();
		s.push(2);
		s.push(1);
		s.getMin();
		s.pop();

	}

	private void pop() {
		
		if(s.isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		Integer t = s.pop();
		
		if(t < minEle) {
			System.out.println("minElem is "+ minEle);
			minEle = 2*minEle -t;
		}
	}

	private void getMin() {
		if(s.isEmpty()) {
			System.out.println("stack is empty ");
			return;
		}
		else {
			System.out.println("minEle is "+minEle);
		}
		
	}

	private void push(int x) {
			
		if(s.isEmpty()) {
			minEle = x;
			s.push(x);
			System.out.println(" stack is empty  and minEle is "+minEle);
			return;
		}
		
		if(x < minEle) {
			s.push(2*x - minEle);
			minEle = x;
		}
		else 
			s.push(x);
		
		System.out.println("number inserted is "+x);
		
	}

}
