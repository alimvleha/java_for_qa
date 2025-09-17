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

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

}
