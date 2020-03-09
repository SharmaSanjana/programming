package sll;

import sll.LinkedList.Node;

class LinkedList1{
	 class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	 }
	 Node head;
	 
	 public void push(int d){
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	 }
	 public void append(int d){
			Node newNode = new Node(10);
			if(head==null){
				head = newNode;
				return;		
			}
			Node findLast = head;
			while(findLast.next!=null){
				findLast = findLast.next;
			}
			findLast.next = newNode;
			return;
	}
	 public void printList() 
		{ 
			Node temp = head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		} 
	 public void delAtGivenPos(int i) {
		 if(head==null) return;
		 if(i==0) {
			 System.out.println("pls provide valid number");
		 }
		 Node before = head;
		 for(int j=1;j<=i-1;j++) {
			 before = before.next;
		 }
		 before.next = before.next.next;
		 
		 
	 }
	 public static void main(String[] args){
		LinkedList1 ll1 = new LinkedList1();
		ll1.push(5);ll1.push(4);ll1.push(3);ll1.push(2);ll1.push(1);
		System.out.println("\nCreated Linked list is: "); 
		ll1.printList(); 
		ll1.delAtGivenPos(3);
		System.out.println("\nafter deleteing ");ll1.printList();
	 }
	 
	
	}
