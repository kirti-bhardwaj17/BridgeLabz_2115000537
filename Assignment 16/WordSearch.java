import java.util.*;
public class WordSearch{
	public static void main(String args[]){
	String words[] = {"hello you all" , "I am Kirti", "I love coding"};
	String s = "Kirti";
	int c=0;
	for(String word : words){
	String arr[] = word.split(" ");
	for(String w:arr){
	if(w.equals(s)) {
	System.out.println(word);
	c++;
	break;
	}
}	}
	if(c == 0) System.out.println("not found");
	}
}
