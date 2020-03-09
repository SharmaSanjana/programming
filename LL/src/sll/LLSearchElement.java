package sll;

public class LLSearchElement {

	class Node{
		int data; Node next;
		Node(int d){
			data = d;next = null;
		}
	}
	Node head;
	private void push(int d) {
		Node n = new Node(d);
		n.next = head;
		head = n;
	}
	private void printll() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.print("null");
	}
	private boolean llSearchItr(int key) {
		Node temp = head;
		if(head==null) return false;
		if(head.data==key) return true;
		while(temp!=null) {
			if(temp.data==key) return true;
			temp=temp.next;
		}
		return false;
	}
	public static void main(String[] args) {
		LLSearchElement ll = new LLSearchElement();
		ll.push(3);ll.push(2);ll.push(1);
		ll.printll();
		System.out.println(ll.llSearchItr(3));
		System.out.println(ll.llSearchRec(9));

	}
	private boolean llSearchRec(int key) {
		Node temp = head;
		return searchKeyRec(temp,key);
	}
	private boolean searchKeyRec(Node head,int key) {
		if(head==null) return false;
		if(head.data==key) return true;
		return searchKeyRec(head.next,key);
	}

}
