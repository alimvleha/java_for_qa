package ru.alimqa.geometry.figures;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSquare {

    @Test
    @Description("Проверяем вычисление площади прямоугольника")
    void testCalculateArea() {
        var result = Square.area(5.0);
        Assertions.assertEquals(25.0, result);
    }

    @Test
    @Description("Проверяем вычисление периметра прямоугольника")
    void testCalculatePerimeter() {
        Assertions.assertEquals(20.0, Square.perimeter(5.0));
    }
}
