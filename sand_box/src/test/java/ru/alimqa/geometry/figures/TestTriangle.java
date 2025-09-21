package ru.alimqa.geometry.figures;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangle {
    @Test
    @Description("Проверяем вычисление периметра треугольника")
    void testCalculateTrianglePerimeter() {
        var p = new Triangle(3.0,4.0,5.0);
        double result = p.perimeter();
        Assertions.assertEquals(12.0, result);
    }

    @Test
    @Description("Проверяем вычисление площади треугольника")
    void testCalculateTriangleArea() {
        var a = new Triangle(3.0,4.0,5.0);
        double result = a.area();
        Assertions.assertEquals(6.0, result);

    }


}
