import java.util.*;
 public class Calculator{
	public static int add(int a, int b){
	return (a+b);
	}
	public static int subtract(int a, int b){
	return a-b;
	}
	public static int multiply(int a, int b){
	return (a*b);
	}
	public static int division(int a,int b){
	return (a/b);
	}
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	System.out.println("enter two numbers");
	int a = sc.nextInt();
	int b=sc.nextInt();
	System.out.println("Enter the operation");
	char c = sc.next().charAt(0);
	if(c=='+') System.out.println(add(a,b));
	if(c=='-') System.out.println(subtract(a,b));
	if(c=='*') System.out.println(multiply(a,b));
	if(c=='/') System.out.println(division(a,b));
	}
}

