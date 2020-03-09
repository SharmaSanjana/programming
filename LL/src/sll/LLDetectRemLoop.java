package sll;

public class LLDetectRemLoop {

	static class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	static Node head;
	public void printLL() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public void push(int d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	public static void main(String[] args) {
		LLDetectRemLoop list = new LLDetectRemLoop();
		list.head = new Node(50); 
        list.head.next = new Node(20); 
        list.head.next.next = new Node(15); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(10); 
		list.printLL();
		head.next.next.next.next.next = head.next.next; 
		list.detectNremoveLoop(head);
		
	}
	private void detectNremoveLoop(Node head) {
		if(head == null || head.next==null) 
			return;
		Node fp = head;
		Node sp = head;
		
		fp = fp.next.next;
		sp = sp.next;
		while(fp!=null && fp.next!=null) {
			if(sp==fp) break;
			fp = fp.next.next;
			sp = sp.next;
		}
		
		if(sp==fp) {
			sp = head;
			while(fp!=sp) {
				fp =fp.next;
				sp = sp.next;
			}
			fp.next = null;
		}
		
	}

}
