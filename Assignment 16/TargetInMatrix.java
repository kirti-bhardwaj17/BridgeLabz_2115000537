import java.util.*;
public class TargetInMatrix{
	public static void main(String args[]){
	int matrix[][] = {{1,2,3},
		          {4,5,6},
			  {7,8,9}};
	int target = 7;			
	int rows = matrix.length;
	int cols = matrix[0].length;
	int left = 0;
	int right = (rows*cols)-1;
	while(left<right){
	int mid = left+(right-left)/2;
	int row = mid / cols;
            int col = mid % cols;
	if(matrix[row][col] == target){
	System.out.println("true");
	return;
	}
	else if(matrix[row][col] > target){
	right = mid;
	}
	else{
	left = mid+1;
	}
	}
	System.out.println("false");
	}
}
