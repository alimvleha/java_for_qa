package ru.alimqa.geometry.figures;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsSquare {

    @Test
    @Description("Проверяем вычисление площади прямоугольника")
    void testCalculateArea() {
        var result = Square.area(4.0);
//        Assertions.assertEquals(25.0, result);
        if (!(result == 25.0)) {
            throw  new AssertionError(String.format("Expected %.1f, actual %.1f", 25.0, result));
        }
    }

    @Test
    @Description("Проверяем вычисление периметра прямоугольника")
    void testCalculatePerimeter() {
        Assertions.assertEquals(20.0, Square.perimeter(5.0));
    }

    @Test
    void testCannotCreateSquareWithNegativeSide() {
        try {
            new Square(5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }
}
