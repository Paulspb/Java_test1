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
      double x2 = 7.4;
      double y2 = 9.7;
      Point1(M,x2,y2);
                  System.out.println("Расстояние между точками A (" + x1 + "/"+ y1 +") и точкой В (" +x2 +"/"+y2 + ") равно = "+ Distance4(x1,x2,y1,y2));

   }

    public static void Point1(String X, double x1, double y1){
        System.out.println("Координаты точки "+X+ " = " + x1 +", Y = " +y1+";");

    }

    public static double Distance4(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2-x1)*2 + (y2-y1)*2);

    }
}