import java.util.*;
public class Compare{
	public static int[] input(int arr[], Scanner sc){
	for(int i=0;i<arr.length;i++){
	arr[i]=sc.nextInt();
	}
	return arr;
	}
	public static int Maximum(int arr[]){
	if((arr[0]>arr[1])&& (arr[0]>arr[2])){
	return arr[0];
	}
	else if((arr[1]>arr[0]) && arr[1]>arr[2]){
	return arr[1];
	}
	else{
	return arr[2];
	}
	}
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int arr[] =  new int[3];
	int max = Maximum(input(arr, sc));
	System.out.println("Maximum number is "+ max);
}
}
