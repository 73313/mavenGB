
public class Triangle   {
    public  int a;
    public  int b;
    public  int c;
   public Triangle(int a, int b,int c) {
       this.a = a;
        this.b = b;
        this.c = c;

   }

    public static double squareTriangle(int a, int b, int c) throws TriangleException {


        double p = (a + b + c) / 2;
        if (a + b <= c || b+c<=a || a+c<=b ) throw new TriangleException("Не является треугольником");
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    public static boolean isTriangle(int a, int b, int c) throws TriangleException {
         System.out.println("Стороны треугольника:" + a + " " + b + " " + c);

      if (a + b > c && b + c > a && c + a > b)
        System.out.println("Это треугольник " +" -"+ "площадь"+ "=" +squareTriangle( a, b, c));
        if(a <=0 || b <= 0 || c<= 0) throw new TriangleException("Не допускаются отрицательные значения ");
        return true;
   }

 // Второй вариант
    public static boolean isTriangle2(int a, int b, int c) throws TriangleException {
        System.out.println("Стороны треугольника:" + a + " " + b + " " + c);

        if(a + b > c && a + c > b && b + c > a){

            if(a == b  && a == c){
                System.out.println(" Равносторонний треугольник" +" -"+ "площадь"+ "=" +squareTriangle( a, b, c));

            }else if(a ==b || a == c || b== c){
                System.out.println("Равнобедренный треугольник" +" -"+ "площадь" + "="+squareTriangle( a, b, c));

            }else {
                System.out.println("Обычный треугольник" +" -"+ "площадь"+ "=" +squareTriangle( a, b, c));
            }
        }else{
           System.out.println(" Не треугольник");}
        return true;

   }

}







