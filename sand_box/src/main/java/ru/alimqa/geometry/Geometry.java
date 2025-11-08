package ru.alimqa.geometry;

import ru.alimqa.geometry.figures.Rectangle;
import ru.alimqa.geometry.figures.Square;
import ru.alimqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public  static  void main (String[] args) {
        var squares = List.of(new Square(7.0), new Square(5.0),new Square(3.0));
//        for (Square square : squares) {
//            Square.printRectangleSquareArea(square);
//        }

        squares.forEach(Square::printRectangleSquareArea);

//
//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(5.0, 10.0);
//
//        Triangle.printTrianglePerimeter(3.0, 4.0, 5.0);
//        Triangle.printTriangleArea(3.0, 4.0, 5.0);
    }
}

