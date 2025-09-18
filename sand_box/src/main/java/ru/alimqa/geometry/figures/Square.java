package ru.alimqa.geometry.figures;

public class Square {
    public static void printRectangleSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + area(side));
    }

    public static double area(double a) {
        return a * a;
    }

    public static double perimeter(double v) {
        return 4 * v;
    }
}
