package ru.alimqa.geometry;

import ru.alimqa.geometry.figures.Rectangle;
import ru.alimqa.geometry.figures.Square;

public class Geometry {
    public  static  void main (String[] args) {
        Square.printSquareArea(10.0);
        Square.printSquareArea(5.0);
        Square.printSquareArea(3.0);

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(5.0, 10.0);
    }

}

