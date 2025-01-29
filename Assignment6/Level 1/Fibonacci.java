import java.util.*;
public class Fibonacci{
	public static int getFibo(int i){
	if(i==1) return 0;
	if(i==2) return 1;
	
	return getFibo(i-1)+getFibo(i-2);
	

	}
	public static void printFibo(int n){
		for(int i=1;i<=n;i++){
		System.out.print(getFibo(i)+" ");
		}
	}
	
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the range");
	int n = sc.nextInt();
	printFibo(n);
}
}
