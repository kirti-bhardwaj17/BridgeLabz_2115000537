public class CollinearPoints {

    public static boolean checkCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double) (y2 - y1) / (x2 - x1);
        double slopeBC = (double) (y3 - y2) / (x3 - x2);
        double slopeAC = (double) (y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    public static boolean checkCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;

        boolean collinearSlope = checkCollinearSlope(x1, y1, x2, y2, x3, y3);
        boolean collinearArea = checkCollinearArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Using Slope Formula: The points are " + (collinearSlope ? "Collinear" : "Not Collinear"));
        System.out.println("Using Area Formula: The points are " + (collinearArea ? "Collinear" : "Not Collinear"));
    }
}
