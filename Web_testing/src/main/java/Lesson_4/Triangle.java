package Lesson_4;

public class Triangle {

    public static void main(String[] args) throws MyExeption {
        int a;
        a = (int) trianleFunction(12, 10, 15);
        System.out.println("Площадь треугольника = " + a);
        a = (int) trianleFunction(10, 15, 20);
        System.out.println("Площадь треугольника = " + a);
        a = (int) trianleFunction(30, 40, 50);
        System.out.println("Площадь треугольника = " + a);

    }
    public static double trianleFunction(int a, int b, int c) throws MyExeption {
        if(a<=0 || b<=0 || c<=0 ) throw new MyExeption("Одна из сторон меньше или равно нулю!");
        int pp = pp = (a + b + c) / 2;
        int result;
        result = (int) Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
        return result;

    }
}
