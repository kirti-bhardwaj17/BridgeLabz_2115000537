import java.util.*;
public class CanVote{
	public static boolean CanStudentVote(int age){
	if(age<0) return false;
	if(age>=18) return true;
	else{
	return false;
}}
	public static void main(String args[]){ Scanner sc = new Scanner(System.in); int age = sc.nextInt();
	 if(CanStudentVote(age))
{ System.out.println("Student can vote");
}
	else{
	System.out.println("Student cannot vote");
	}
}
}
