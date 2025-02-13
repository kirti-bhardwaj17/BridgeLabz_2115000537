import java.util.*;
public class QueueUsingStacks{
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	void enqueue(int n){
	s1.push(n);
	}
	public int dequeue(){
	if(s2.isEmpty()){
		if(s1.isEmpty()){
		System.out.println("Empty queue");
	}
	while(!s1.isEmpty()){
	s2.push(s1.pop());
	}
	}
	return s2.pop();
}
	public static void main(String args[]){
	QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
	System.out.println(q.dequeue());
	 System.out.println(q.dequeue());
	q.enqueue(5);
	 System.out.println(q.dequeue());
	 System.out.println(q.dequeue());
	 System.out.println(q.dequeue());
}
}
	
	
