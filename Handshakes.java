import java.util.*;
public class Handshakes{
        public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int Students = sc.nextInt();
        int Total= (Students*(Students-1))/2;
        System.out.println("The total handshakes are "+Total);
}
}
