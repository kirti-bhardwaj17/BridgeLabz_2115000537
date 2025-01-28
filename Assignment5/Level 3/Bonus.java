public class Bonus {

    public static int[][] generateEmployeeData(int numEmployees) {
        int[][] employeeData = new int[numEmployees][2];
        for (int i = 0; i < numEmployees; i++) {
            employeeData[i][0] = (int) (Math.random() * 90000) + 10000; 
            employeeData[i][1] = (int) (Math.random() * 10) + 1; 
        }
        return employeeData;
    }

    public static double[][] calculateBonusAndSalary(int[][] employeeData) {
        int numEmployees = employeeData.length;
        double[][] bonusAndSalary = new double[numEmployees][3];
        for (int i = 0; i < numEmployees; i++) {
            int oldSalary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonusPercent = (years > 5) ? 5 : 2;
            double bonusAmount = oldSalary * bonusPercent / 100;
            double newSalary = oldSalary + bonusAmount;

            bonusAndSalary[i][0] = bonusAmount;
            bonusAndSalary[i][1] = newSalary;
            bonusAndSalary[i][2] = bonusPercent;
        }
        return bonusAndSalary;
    }

    public static void displayDetails(int[][] employeeData, double[][] bonusAndSalary) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.println("ID\tOld Salary\tYears\tBonus %\tBonus\tNew Salary");
        for (int i = 0; i < employeeData.length; i++) {
            int oldSalary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonusAmount = bonusAndSalary[i][0];
            double newSalary = bonusAndSalary[i][1];
            double bonusPercent = bonusAndSalary[i][2];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonusAmount;

            System.out.printf("%d\t%d\t\t%d\t%.0f%%\t%.2f\t%.2f\n", 
                              i + 1, oldSalary, years, bonusPercent, bonusAmount, newSalary);
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;

        int[][] employeeData = generateEmployeeData(numEmployees);
        double[][] bonusAndSalary = calculateBonusAndSalary(employeeData);

        displayDetails(employeeData, bonusAndSalary);
    }
}
