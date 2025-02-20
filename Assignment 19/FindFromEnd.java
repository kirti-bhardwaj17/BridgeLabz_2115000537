import java.util.*;
public class FindFromEnd{
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
        public  int find(int N){
        Node curr = head;
        Node temp=null;
        Node prev=null;
        while(curr != null){
        temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        }
        head = prev;
	Node c = head;
	for(int i=1;i<N;i++){
	c=c.next;
	}
	return c.data;
}
	
        public void display(){
        Node curr = head;
        while(curr != null){
        System.out.print(curr.data + "-> ");
        curr = curr.next;
           }
        System.out.print("null\n");
}

  public static void main(String args[]){
	FindFromEnd list = new FindFromEnd();
	list.addFirst(6);
	list.addFirst(5);
	list.addFirst(4);
	list.addFirst(3);
	list.addFirst(2);
	list.addFirst(1);
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int res = list.find(N);
	System.out.println(res);
	}
}
