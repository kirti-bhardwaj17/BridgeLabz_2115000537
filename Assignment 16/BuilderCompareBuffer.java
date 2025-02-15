import java.util.*;
public class BuilderCompareBuffer{
	public static void main(String args[]){
	String s = "hello";
	StringBuilder sb1 = new StringBuilder();
	StringBuffer sb2 = new StringBuffer();
	long start1 = System.nanoTime();
	for(int i=0;i<1000000;i++){
	sb1.append(s);
	}
	long end1 = System.nanoTime();
	long t1 = end1-start1;
	long start2 = System.nanoTime();
	for(int i=0;i<1000000;i++){
	sb2.append(s) ;
	}
	long end2 = System.nanoTime();
	long t2 = end2-start2;
	if(t1>t2){
	System.out.println("StringBuilder takes more time and is slow");
	}
	else{
	System.out.println("StringBuffer takes more time and is slow");
	}
	}
}
