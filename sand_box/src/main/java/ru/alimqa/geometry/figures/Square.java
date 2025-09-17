package ru.alimqa.geometry.figures;

public class Square {
    public static void printRectangleSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareRectangleArea(side));
    }

    private static double squareRectangleArea(double a) {
        return a * a;
    }

    public static void printTriangleArea(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        System.out.println("Площадь треугольника со сторонами " + a + ", " + b + ", " + c + " = " + triangle.area());
    }
}
