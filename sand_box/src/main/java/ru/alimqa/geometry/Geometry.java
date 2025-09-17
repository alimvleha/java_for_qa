package ru.alimqa.geometry;

import ru.alimqa.geometry.figures.Perimeter;
import ru.alimqa.geometry.figures.Rectangle;
import ru.alimqa.geometry.figures.Square;

public class Geometry {
    public  static  void main (String[] args) {
        Square.printRectangleSquareArea(10.0);
        Square.printRectangleSquareArea(5.0);
        Square.printRectangleSquareArea(3.0);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(5.0, 10.0);

        Perimeter.printTrianglePerimeter(3,4,5);
        Square.printTriangleArea(3,4,5);
    }
}

