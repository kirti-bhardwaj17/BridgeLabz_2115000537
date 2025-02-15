import java.util.*;
public class Smallest{
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size");
        int size = sc.nextInt();
	int arr[] = new int[size];
	System.out.println("enter the rotated sorted array");
	for(int i=0;i<size;i++){
	arr[i] = sc.nextInt();
	}
	int left=0;
	int right = arr.length -1;
	while(left<right){
	int mid = left+(right-left)/2;
	if(arr[mid]>arr[right]){
	left = mid+1;
	}
	else{
	right = mid;
	}
	}
	System.out.println(arr[left]);
	}
	}
