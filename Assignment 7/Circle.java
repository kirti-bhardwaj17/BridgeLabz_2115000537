import java.util.*;
public class Circle{
        double radius;
        public Circle(double radius){
        this.radius = radius;
        }
        public double calculateCircumference(){
                 double circumference = 2*3.14*radius;
                return circumference;
        }
        public double calculateArea(){
                double area = 3.14*radius*radius;
                return area;
        }
        public void display(){
         System.out.println("Circumference: " + calculateCircumference());
        System.out.println("Area: " + calculateArea());
        }
        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        c.display();
}
}
