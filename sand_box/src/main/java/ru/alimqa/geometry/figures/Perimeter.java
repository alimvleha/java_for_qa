package ru.alimqa.geometry.figures;

public class Perimeter {
    public static void printTrianglePerimeter(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        var perimeter = String.format("Периметр треугольника со сторонами  %.1f, %.1f, %.1f = %.1f", a, b, c, perimeter(triangle));
        System.out.println(perimeter);
    }

    public static double perimeter(Triangle triangle) {
        return triangle.sideA + triangle.sideB + triangle.sideC;
    }
}
