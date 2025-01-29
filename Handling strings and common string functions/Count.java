import java.util.*;
public class Count{
	public static void main(String args[]){
	String str = new String();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the string");
	str = sc.nextLine();
	int v=0;
	int c=0;
	for(int i=0;i<str.length();i++){
	if(str.charAt(i) == 'a' || str.charAt(i) == 'e'|| str.charAt(i) == 'i' || str.charAt(i) == 'o' ||str.charAt(i) == 'u' || str.charAt(i) == 'A' ||
	 str.charAt(i) == 'E'|| str.charAt(i) == 'I' || str.charAt(i) == 'O' ||str.charAt(i) == 'U')
	{
	 v+=1;
	}
	else{
	 c+=1;
	}
	
	}
        System.out.println(" count of consonents "+c+" counts of vowels is "+v);

}
}
