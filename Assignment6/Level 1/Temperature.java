import java.util.*;
public class Temperature{
	public static double fahrenheit(double c){
	 double f = ((9/5)*c)+32;
	return f;
	}
	public static double celsius(double f){
	double c = ((5/9)*(f-32));
	return c;
	}
	public static void main(String args[]){ Scanner sc = new 
	Scanner(System.in); System.out.println("Enter the temperature in fahrenheit");
 double f = sc.nextDouble(); System.out.println("Enter the temperature in celsius"); 
	double c = sc.nextDouble(); 
	System.out.println(f+" in celsius is "+fahrenheit(f)); 
	System.out.println(c+" in fahrenheit is "+celsius(c));
}
}
