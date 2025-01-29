import java.util.*;
public class Palindrome{
        public static boolean check(String s){
        for(int i=0;i<s.length()/2;i++){
	if(s.charAt(i) != s.charAt((s.length()-1)-i))
	return false;


        }
	return true;
	}
        public static String input(Scanner sc){
	String s;
	 s=sc.nextLine();
	return s;
	}

        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        
        if(check(input(sc))) System.out.println("Palindrome");
	else System.out.println("Not PAlindrome");

}
}

