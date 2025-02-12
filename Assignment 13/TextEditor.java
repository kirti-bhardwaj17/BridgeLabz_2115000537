public class TextEditor{
	class Node{
	String text;
	Node next,prev;
	 Node(String text){
	this.text = text;
	}}
	Node head , tail , current;
	private final int maxState = 10;
	private int size=0;
	public void addState(String text){
	Node newNode = new Node(text);
	if(current !=null){
	newNode.prev = current;
	current.next = newNode;
	}
	else{
	head = newNode;
	}
	current = newNode;
	tail = current;
	size++;
	if(size > maxState){
	head = head.next;
	head.prev = null;
	size--;
	}
	}
	public void undo(){
	if(current != null && current.prev != null){
	current = current.prev;
	}
	}
	public void redo(){
	if(current != null && current.next != null){
	current = current.next;
	}
	}
	public void displayState(){
	if(current != null ){
	System.out.println("current state "+current.text);
	}
	else{
	System.out.println("No text available");
	}}
	public static void main(String args[]){
	TextEditor t = new TextEditor();
	t.addState("Hello");
	t.addState("Everyone");
	t.addState("All good? ");
	
	t.displayState();
	t.undo();
	t.displayState();
	t.redo();
	t.displayState();
	}
}
