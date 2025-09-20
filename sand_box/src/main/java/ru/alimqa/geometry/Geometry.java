package ru.alimqa.geometry;

import ru.alimqa.geometry.figures.Rectangle;
import ru.alimqa.geometry.figures.Square;
import ru.alimqa.geometry.figures.Triangle;

public class Geometry {
    public  static  void main (String[] args) {
        Square.printRectangleSquareArea(10.0);
        Square.printRectangleSquareArea(5.0);
        Square.printRectangleSquareArea(3.0);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(5.0, 10.0);

        Triangle.printTrianglePerimeter(3.0, 4.0, 5.0);
        Triangle.printTriangleArea(3.0, 4.0, 5.0);
    }
}

