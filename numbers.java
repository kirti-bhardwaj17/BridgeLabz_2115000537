import java.util.*;
public class numbers{
	public static void main(String args[]){
	Scanner sc= new Scanner(System.in);
	int number1= sc.nextInt();
	int number2= sc.nextInt();
	int q=number1/number2;
	int r = number1%number2;
	System.out.println(" The Quotient is "+q+" and Reminder is "+r+" of two number "+number1+" and "+number2);
}
}
