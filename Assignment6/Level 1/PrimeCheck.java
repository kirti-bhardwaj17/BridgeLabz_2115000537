import java.util.*;
public class PrimeCheck{
	public static Boolean Check(int n){
	if(n<2) return false;
	for(int i=2;i<=Math.sqrt(n);i++){
	if((n%i)==0) return false;
	}
	return true;
	}
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	if(Check(n)) System.out.println(n+" is a prime number");
	else{
	System.out.println(n +" is not a prime number");
	}
	}
	}
