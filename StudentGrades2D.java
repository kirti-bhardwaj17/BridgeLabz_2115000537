import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            System.out.print("Physics: ");
            marks[i][0] = sc.nextDouble();
            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextDouble();
            System.out.print("Maths: ");
            marks[i][2] = sc.nextDouble();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Marks cannot be negative. Please enter valid marks.");
                i--;
                continue;
            }

            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (total / 300) * 100;

            if (percentages[i] >= 90) grades[i] = "A+";
            else if (percentages[i] >= 80) grades[i] = "A";
            else if (percentages[i] >= 70) grades[i] = "B";
            else if (percentages[i] >= 60) grades[i] = "C";
            else if (percentages[i] >= 50) grades[i] = "D";
            else grades[i] = "F";
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " - Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }

        sc.close();
    }
}
