package ru.alimqa.geometry.figures;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangle {
    @Test
    @Description("Проверяем вычисление периметра треугольника")
    void testCalculateTrianglePerimeter() {
        var result = Triangle.perimeter(3.0, 4.0, 5.0);
        Assertions.assertEquals(12.0, result);
    }

    @Test
    @Description("Проверяем вычисление площади треугольника")
    void testCalculateTriangleArea() {
        var result = Triangle.area(3.0, 4.0, 5.0);
        Assertions.assertEquals(6.0, result);
    }
}
