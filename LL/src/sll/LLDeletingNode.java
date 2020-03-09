package sll;

public class LLDeletingNode {

	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	
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
	private void delete(int key) {
		Node temp = head;
		if(temp.data==key && temp!=null) {
			head = null;
			return;
		}
		Node prev_node = null;
		while(temp.data!=key && temp!=null) {
			prev_node = temp;
			temp = temp.next;
		}
		if(temp==null) return;
		prev_node.next = prev_node.next.next;
	}
	public static void main(String[] args) {
		LLDeletingNode ll = new LLDeletingNode();
		ll.push(3);ll.push(2);ll.push(1);
		ll.printLL();	
		ll.delete(2);
		ll.printLL();
		ll.push(2);ll.printLL();
	}
	
}
