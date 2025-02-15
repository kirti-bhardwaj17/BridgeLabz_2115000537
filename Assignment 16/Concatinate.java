import java.util.*;
public class Concatinate{
	public static void main(String args[]){
	String str[] = {"hello" , "everyone" , "all" , "good?"};
	StringBuffer sb = new StringBuffer();
	for(String s:str){
	sb.append(s);
	}
	sb.toString();
	System.out.println(sb);
	}
	}
	
