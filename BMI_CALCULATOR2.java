import java.util.Scanner;

public class BMI_CALCULATOR2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        
        double[][] data = new double[n][3];
        String[] status = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (m) for person " + (i+1) + ": ");
            data[i][1] = sc.nextDouble();
            
            data[i][2] = data[i][0] / (data[i][1] * data[i][1]);
            
            if (data[i][2] < 18.5) status[i] = "Underweight";
            else if (data[i][2] < 24.9) status[i] = "Normal weight";
            else if (data[i][2] < 29.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i+1) + " - Weight: " + data[i][0] + " kg, Height: " + data[i][1] + " m, BMI: " + data[i][2] + ", Status: " + status[i]);
        }
        
        sc.close();
    }
}
