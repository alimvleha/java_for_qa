package ru.alimqa.geometry.figures;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangle {
    @Test
    @Description("Проверяем вычисление периметра треугольника")
    void testCalculateTrianglePerimeter() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double result = Perimeter.perimeter(triangle);
        Assertions.assertEquals(12.0, result);
    }

    @Test
    @Description("Проверяем вычисление площади треугольника")
    void testCalculateTriangleArea() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double result = triangle.area();
        Assertions.assertEquals(6.0, result);
    }
}
