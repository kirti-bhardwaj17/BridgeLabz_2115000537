import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        
        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentages = new double[n];
        String[] grades = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for Physics for student " + (i+1) + ": ");
            physics[i] = sc.nextDouble();
            System.out.print("Enter marks for Chemistry for student " + (i+1) + ": ");
            chemistry[i] = sc.nextDouble();
            System.out.print("Enter marks for Maths for student " + (i+1) + ": ");
            maths[i] = sc.nextDouble();
            
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Marks cannot be negative. Please enter valid marks.");
                i--;
                continue;
            }
            
            double total = physics[i] + chemistry[i] + maths[i];
            percentages[i] = (total / 300) * 100;
            
            if (percentages[i] >= 80) grades[i] = "A+";
            else if (percentages[i] <= 79) grades[i] = "A";
            else if (percentages[i] >= 70) grades[i] = "B";
            else if (percentages[i] >= 60) grades[i] = "C";
            else if (percentages[i] >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + " - Physics: " + physics[i] + ", Chemistry: " + chemistry[i] + ", Maths: " + maths[i]);
            System.out.println("Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }
        
        sc.close();
    }
}
