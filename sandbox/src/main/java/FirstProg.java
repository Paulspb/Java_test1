public class FirstProg{

  public static void main(String[] args) {

      System.out.println("Hello Java !");
      // задание 1 - функия Point1
      String M = "A";
      double x1 = 4.2;
      double y1 = 5.7;
      Point1(M,x1,y1);

      // задание 2 - функия Distance
      M = "B";
      double x2 = 17.4;
      double y2 = 29.7;
      Point1(M,x2,y2);
      System.out.println("Расстояние между точками A (" + x1 + "/"+ y1 +") и точкой В (" +x2 +"/"+y2 + ") равно = "+ Distance4(x1,y1,x2,y2));

      Point  p1 = new Point(4.2,5.7);
      Point  p2 = new Point(17.4,29.7);
      System.out.println("Координаты точки p1 "+  p1 +";");
      System.out.println("Координаты точки p2 "+  p2 +";");
      Distance(p1,p2);
      System.out.println("Дистанция  "+ " p2 <-> p1 = " + Distance(p1,p2) +";");
      System.out.println("Дистанция2 "+ " p2 <-> p1 = " + Distance2(p1,p2) +";");
  }

    public static void Point1(String X, double x1, double y1){
        System.out.println("Координаты точки "+X+ ": (x/y) = " + x1 +"/" +y1+";");

    }

    public static double Distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p2.x - p1.x,2.0) + Math.pow(p2.y -p1.y,2.0));
    }

    public static double Distance2(Point p1, Point p2){

        return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y -p1.y)*(p2.y -p1.y));
    }
    public static void Point2(String X, double x1, double y1){
        System.out.println("Координаты точки "+X+ ": (x/y) = " + x1 +"/" +y1+";");

    }

    public static double Distance4(double x1, double y1, double x2, double y2) {

        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

    }
}
