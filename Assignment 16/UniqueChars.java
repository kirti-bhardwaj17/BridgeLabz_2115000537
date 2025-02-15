import java.util.*;
public class UniqueChars{
	public static void main(String args[]){
	String s = "abbbcccddefggg";
	StringBuilder sb = new StringBuilder();
	HashSet<Character> set = new HashSet<>();
	for(int i=0;i<s.length();i++){
	char c = s.charAt(i);
	if(!set.contains(c)){
	set.add(c);
	sb.append(c);
	}
	}
	String ans=sb.toString();
	System.out.println(ans);
	}
	}
