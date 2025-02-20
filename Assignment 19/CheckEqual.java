import java.util.*;
public class CheckEqual{
	public static boolean check(HashSet<Integer> set1, HashSet<Integer> set2){
	if(set1.size() == set2.size()){
	for(int key:set1){
	if(!set2.contains(key)){
	return false;
	}
	}
}
	return true;
	}
	public static void main(String args[]){
	HashSet<Integer> set1 = new HashSet<>();
	set1.add(3);
	set1.add(4);
	set1.add(1);
	HashSet<Integer> set2 = new HashSet<>();
	set2.add(3);
	set2.add(4);
	set2.add(1);
	if(check(set1,set2)) System.out.println("true");
	else System.out.println("false");
}
}
