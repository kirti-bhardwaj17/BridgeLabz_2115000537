import java.util.*;
public class SumUsingRecussion{
	int s=0;
	static int sum(int n){
	if(n==0) return 0;
	return n+sum(n-1);
}
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n= sc.nextInt();
	int total=(n*(n+1))/2;
	if(total == sum(n)) System.out.println(total);
	}
}
