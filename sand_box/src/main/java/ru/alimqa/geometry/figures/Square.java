package ru.alimqa.geometry.figures;

public class Square {
    public static void printRectangleSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareRectangleArea(side));
    }

    private static double squareRectangleArea(double a) {
        return a * a;
    }
}
