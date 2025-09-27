package ru.alimqa.geometry.figures;

import java.util.Objects;

public record Triangle(double sideA, double sideB, double sideC) {
    
    public Triangle{
        if (sideA < 0 || sideB < 0 || sideC < 0) {
            throw new IllegalArgumentException("Длина стороны треугольника должна быть неотрицательной");
        }
        if ((sideA + sideB < sideC) || (sideA + sideC < sideB) || (sideB + sideC < sideA)) {
            throw new IllegalArgumentException("Нарушение неравенства треугольника: сумма любых двух сторон должна быть не меньше третьей стороны");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.sideA, sideA) == 0 && Double.compare(triangle.sideB, sideB) == 0 && Double.compare(triangle.sideC, sideC) == 0) ||
                (Double.compare(triangle.sideA, sideA) == 0 && Double.compare(triangle.sideB, sideC) == 0 && Double.compare(triangle.sideC, sideB) == 0) ||
                (Double.compare(triangle.sideA, sideB) == 0 && Double.compare(triangle.sideB, sideA) == 0 && Double.compare(triangle.sideC, sideC) == 0) ||
                (Double.compare(triangle.sideA, sideB) == 0 && Double.compare(triangle.sideB, sideC) == 0 && Double.compare(triangle.sideC, sideA) == 0) ||
                (Double.compare(triangle.sideA, sideC) == 0 && Double.compare(triangle.sideB, sideA) == 0 && Double.compare(triangle.sideC, sideB) == 0) ||
                (Double.compare(triangle.sideA, sideC) == 0 && Double.compare(triangle.sideB, sideB) == 0 && Double.compare(triangle.sideC, sideA) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}