import java.util.*;
public class RemoveDuplicates{
	public static ArrayList<Integer> remove(List<Integer> list){
	HashSet<Integer> set = new HashSet<>();
	ArrayList<Integer> res = new ArrayList<>();
	for(int i=0;i<list.size();i++){
	if(!set.contains(list.get(i))){
	set.add(list.get(i));
	res.add(list.get(i));
	}
	}
	return res;
}
	public static void main(String args[]){
	ArrayList<Integer> List = new ArrayList<>(Arrays.asList(8,4,4,9,2,8,1,0,6,2,5,1,2,3,4));
	ArrayList<Integer> res = remove(List);
	System.out.println(res);
	}
}
