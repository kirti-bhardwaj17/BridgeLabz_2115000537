import java.util.*;
public class ReverseList{
	class Node{
	int data;
	Node next;
	Node(int data){
	this.data = data;
	this.next = null;
	}
	}
	Node head;
	public void addFirst(int data){
	Node newNode = new Node(data);
	if(head == null){
	head = newNode;
	return;
	}
	else{
	newNode.next = head;
	head = newNode;
	}
	}
	public void reverse(){
	Node curr = head;
	Node temp=null;
	Node prev=null;
	while(curr != null){
	if(curr == head){
	temp = curr.next;
	curr.next = null;
	prev = curr;
	curr = temp;
	}
	else{
	temp = curr.next;
	curr.next = prev;
	prev = curr;
	curr = temp;
	}
	}
	head = prev;
}
	public void display(){
	Node curr = head;
	while(curr != null){
	System.out.print(curr.data + "-> ");
	curr = curr.next;
	}
	System.out.print("null\n");
}
	public static List<Integer> reverselist(List<Integer> list){
	for(int i=0;i<list.size()/2;i++){
	int temp = list.get(list.size()-1-i);
	list.set(list.size()-1-i, list.get(i));
	list.set(i , temp);
	
	}
	return list;
}
	public static void main(String args[]){
	ReverseList llist = new ReverseList();
	llist.addFirst(4);
	llist.addFirst(3);
	llist.addFirst(2);
	llist.addFirst(1);
	llist.display();
	llist.reverse();
	llist.display();
	
	ArrayList<Integer> list = new ArrayList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	reverselist(list);
	System.out.println(list);
	

}
}
