import java.util.*;
public class CheckLeapYear{
	void check(int y){
	if(y>=1582) {
	if((y%4==0)&&(y%100 != 0)||(y%400==0)){
	System.out.println("year is a leap year");
	}else{
		System.out.println("Not a leap Year");
}
}
}
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int y = sc.nextInt();
	CheckLeapYear ly = new CheckLeapYear();
	ly.check(y);
}
} 
