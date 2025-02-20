import java.util.*;
public class Frequency{
	public static HashMap<String , Integer> count(List<String> list){
	HashMap<String ,Integer> map = new HashMap<>();
	for(int i=0;i<list.size();i++){
	if(!map.containsKey(list.get(i))){
	map.put(list.get(i),1);
	}
	else{
	map.put(list.get(i),map.get(list.get(i))+1);
	}
	}
	return map;
	}
	public static void main(String args[]){
	 ArrayList<String> list = new ArrayList<>(); 
	list.add("apple");
	list.add("mango");
	list.add("apple");
	list.add("kiwi");
	list.add("kiwi");
	list.add("apple");
	HashMap<String,Integer> map =	count(list);
	System.out.println(map);
}
}
