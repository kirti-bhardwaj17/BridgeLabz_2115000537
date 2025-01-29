import java.util.*;
public class reverse{
	public static void main(String args[]){
	String str = "HelloWorld";
	char[] arr = str.toCharArray();
	for(int i=0;i<arr.length/2;i++){
	char temp= arr[i];
	 arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
	}
	str = new String(arr);
	System.out.print(str);
	}
}
