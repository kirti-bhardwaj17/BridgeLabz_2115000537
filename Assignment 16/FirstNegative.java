import java.util.*;
public class FirstNegative{
	public static void main(String args[]){
	int arr[] = {9,8,-3,7,5,-4};
	for(int i=0;i<arr.length;i++){
	if(arr[i] < 0){
	System.out.println(i);
	return;
	}
	}
	System.out.println("No negative number found");
	}
}
