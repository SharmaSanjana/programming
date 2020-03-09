package sll;

public class LLDeleteNodeAtGivenPosition {

	Node head;
	class Node{
		int data;Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	public void printLL() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+ "->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	private void push(int i) {
		Node new_node = new Node(i);		
		new_node.next = head;
		head = new_node;		
	}
	private void deleteNode(int position) {
		Node temp = head;
		if(head == null) return;
		if(position == 0) {
			head = null;
			return;
		}
		for(int i=0;i<position-1;i++) 
			temp = temp.next;
				
		temp.next = temp.next.next;
		
	}
	public static void main(String[] args) {
		LLDeleteNodeAtGivenPosition ll = new LLDeleteNodeAtGivenPosition();
		ll.push(3);ll.push(2);ll.push(1);
		ll.printLL();	
		ll.deleteNode(2);
		ll.printLL();
		ll.push(2);ll.printLL();
	}

}
