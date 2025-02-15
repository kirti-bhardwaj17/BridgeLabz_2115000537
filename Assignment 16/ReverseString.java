import java.util.*;
public class ReverseString{
	public static void main(String args[]){

	String s = "hello";
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<s.length();i++){
	sb.append(s.charAt(i));
	}
	sb.reverse();
	String reversed = sb.toString();
	System.out.println(reversed);
	}
	}
	
