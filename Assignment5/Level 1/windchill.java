import java.util.Scanner;

public class windchill {
    public static double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(temperature,0.16);
        return windChill;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        double speed = sc.nextDouble();
        double wc = calculateWindChill(temp, speed);
        System.out.println("the windchill is " + wc);
    }
}
