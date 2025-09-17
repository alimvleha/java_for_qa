package ru.alimqa.geometry.figures;

public class Triangle {
    public double sideA;
    public double sideB;
    public double sideC;

    public Triangle(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public static void printTriangleArea(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        var area = String.format("Площадь треугольника со сторонами %.1f, %.1f, %.1f = %.1f", a, b, c, triangle.area());
        System.out.println(area);
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    private double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}