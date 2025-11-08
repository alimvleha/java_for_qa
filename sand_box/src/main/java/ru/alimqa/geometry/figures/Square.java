package ru.alimqa.geometry.figures;

public class Square {
    private double side;

    public Square(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Square side should be non-negative");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public static void printRectangleSquareArea(Square square) {
        System.out.println("Площадь квадрата со стороной " + square.getSide() + " = " + area(square.getSide()));
    }

    public static void printPerimeter(Square square) {
        System.out.println("Периметр квадрата со стороной " + square.getSide() + " = " + perimeter(square.getSide()));
    }

    public static double area(double a) {
        return a * a;
    }

    public static double perimeter(double side) {
        return 4 * side;
    }
}