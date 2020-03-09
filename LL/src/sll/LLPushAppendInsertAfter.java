package sll;

public class LLPushAppendInsertAfter {
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	
	public void push(int d) {
		Node new_node = new Node(d);
		new_node.next = head;
		head = new_node;
	}
	
	public void append(int d) {
		Node new_node = new Node(d);		
		if(head==null) {
			head = new_node;
			return;
		}
		new_node.next = null;
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new_node;
	}
	
	public void insertAfter(Node prev_node, int new_data) {
		
		Node new_node = new Node(new_data);
		
		if(prev_node == null) {
			System.out.println("Given previous node can't ben ull");
			return;
		}
		
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	public void printLL() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public static void main(String args[]) {
		LLPushAppendInsertAfter ll = new LLPushAppendInsertAfter();
		ll.push(2);ll.push(1);
		ll.append(6);
		ll.insertAfter(ll.head.next,3);
		ll.printLL();
	}
}
