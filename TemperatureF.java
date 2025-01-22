import java.util.*;
public class TemperatureF{
        public static void main(String args[]){ Scanner sc= new Scanner(System.in);
        double farenheit=sc.nextDouble();

        double CelsiusResult = (farenheit -32.0) * (5.0/9);
        System.out.println("The "+farenheit+" farenheit is "+CelsiusResult+" celsius");
}
}
