package ru.alimqa.geometry;

import ru.alimqa.geometry.figures.Rectangle;
import ru.alimqa.geometry.figures.Square;
import ru.alimqa.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public  static  void main (String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);

        squares.peek(Square::printRectangleSquareArea).forEach(Square::printPerimeter);



//        for (Square square : squares) {
//            Square.printRectangleSquareArea(square);
//        }

//        squares.forEach(Square::printRectangleSquareArea);

//
//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(5.0, 10.0);
//
//        Triangle.printTrianglePerimeter(3.0, 4.0, 5.0);
//        Triangle.printTriangleArea(3.0, 4.0, 5.0);
    }
}

