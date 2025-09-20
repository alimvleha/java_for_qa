package ru.alimqa.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b  +" = " + area(a, b)) ;
    }

    private static double area(double a, double b) {
        return a * b;
    }
}
