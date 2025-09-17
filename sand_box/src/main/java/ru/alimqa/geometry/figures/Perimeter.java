package ru.alimqa.geometry.figures;

public class Perimeter {
    public static void printTrianglePerimeter(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        System.out.println("Периметр треугольника со сторонами " + a + ", " + b + ", " + c + " = " + triangle.perimeter());
    }
}
