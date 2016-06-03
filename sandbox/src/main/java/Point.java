import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

/**
 * Created by khomep on 25.05.2016.
 */
public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public  double distance3(Point point2){
        return Math.sqrt(Math.pow(point2.x - x,2.0) + Math.pow(point2.y -y,2.0));
    }

    public double length() {
        return x * x + y * y;
    }

    public static void test() {
        int x1 = 1;
        int x2 = 3;
        System.out.println(x1 + x2);

    }
}

