import java.util.*; 
public class distance{
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	double distanceInFeets = sc.nextDouble();
	double distanceInYards = distanceInFeets/3;
	double distanceInMiles = distanceInYards/1760;
	System.out.println("The Distance in Feets is "+distanceInFeets+" while in Yards is "+distanceInYards+" and in Miles is "+distanceInMiles);
}
}
