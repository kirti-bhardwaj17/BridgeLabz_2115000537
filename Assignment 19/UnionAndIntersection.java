import java.util.*;
public class UnionAndIntersection{
	public static void main(String args[]){
	HashSet<Integer> set1 = new HashSet<>();
	HashSet<Integer> set2 = new HashSet<>();
	set1.add(1);
	set1.add(2);
	set1.add(3);
	set2.add(3);
	set2.add(4);
	set2.add(5);
	HashSet<Integer> Union = new HashSet<>();
	ArrayList<Integer> list = new ArrayList<>();
	for(int num:set1){
	Union.add(num);
	}
	for(int num:set2){
	if(Union.contains(num)) list.add(num);
	Union.add(num);
	}
	System.out.println("Union of set is "+Union);
	System.out.println("Intersection is "+list);
}
}
	
