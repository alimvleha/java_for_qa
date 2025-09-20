package ru.alimqa.geometry.figures;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public static void printTriangleArea(double a, double b, double c) {
        System.out.println(String.format("Площадь треугольника со сторонами %.1f и %.1f и %.1f = %.1f",
                a, b, c, area(a, b, c)));
    }

    public static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void printTrianglePerimeter(double a, double b, double c) {
        System.out.println(String.format("Периметр треугольника со сторонами %.1f и %.1f и %.1f = %.1f",
                a, b, c, perimeter(a, b, c)));
    }

    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public double area() {
        return area(sideA, sideB, sideC);
    }

    public double perimeter() {
        return perimeter(sideA, sideB, sideC);
    }

    public void printArea() {
        printTriangleArea(sideA, sideB, sideC);
    }

    public void printPerimeter() {
        printTrianglePerimeter(sideA, sideB, sideC);
    }
}