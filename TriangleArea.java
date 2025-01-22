import java.util.*;
public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double heightInCm = sc.nextDouble();
	double baseInCm = sc.nextDouble();
        double heightInInches=heightInCm/2.54;
        double baseInInches= baseInCm/2.54;
	double	AreaInCm = (0.5)*(baseInCm*heightInCm);
	double AreaInInches = (0.5)*(baseInInches*heightInInches);

        System.out.println("The area in square inches is "+AreaInInches+" while in square centimeters is "+AreaInCm);
    }
}

