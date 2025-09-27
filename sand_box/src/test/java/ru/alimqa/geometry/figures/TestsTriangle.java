package ru.alimqa.geometry.figures;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsTriangle {
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

    @Test
    @Description("Проверяем, что нельзя создать треугольник с отрицательной стороной")
    void testCreateTriangleWithNegativeSide() {
        try {
            new Triangle(3.0, 4.0, -5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }
    @Test
    @Description("Проверяем, что нельзя создать треугольник с нарушением неравенства")
    void testCannotCreateTriangleWithInvalidSides() {
        try {
            new Triangle(3.0, 4.0, 20.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }
//    @Test
//    void test() {
//        var t1 = new Triangle(3, 4, 5);
//        var t2 = new Triangle(3, 2, 3);
//        Assertions.assertNotEquals(t1,t2);
//    }
//
    @Test
    @Description("Проверяем, что треугольники с одинаковыми сторонами считались равными")
    void testTriangleEqual() {
        var t1 = new Triangle(3, 4, 5);
        var t2 = new Triangle(3, 4, 5);
        Assertions.assertTrue(t1.equals(t2));
    }

    @Test
    @Description("Проверяем, что треугольники с одинаковыми сторонами считались равными, независимо от порядка сторон")
    void testTriangleEquality() {
        var t1 = new Triangle(3, 4, 5);
        var t2 = new Triangle(5, 4, 3);
        Assertions.assertTrue(t1.equals(t2));
    }
}
