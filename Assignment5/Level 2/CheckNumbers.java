import java.util.*;
public class CheckNumbers{
	public static void IsPositive(int arr[]){
	for(int i=0;i<arr.length;i++){
	if(arr[i]>0) System.out.println(arr[i]+"is positive");
	else System.out.println(arr[i]+"is negative");
	}
	}	
	public static void isOdd(int arr[]){
	for(int i=0;i<arr.length;i++){
	if(arr[i]%2==0) System.out.println(arr[i]+" is even");
	else System.out.println(arr[i]+" is odd");
	}
}
	public static void compare(int arr[]){
	if(arr[0] > arr[arr.length-1]) System.out.print(arr[0]+" is greater");
	else if(arr[0] < arr[arr.length-1]) System.out.println(arr[0]+" is small");
	else System.out.print("equal");
	}
	public static void main(String args[]){
	Scanner sc= new Scanner(System.in);
	int arr[] = new int[5];
	System.out.println("enter 5 numbers");
	for(int i=0;i<arr.length;i++){
	arr[i]=sc.nextInt();
	}
	IsPositive(arr);
	isOdd(arr);
	compare(arr);
}
}
