package com.geekbrains.lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CalcAreaTest {
    private static Logger logger = LoggerFactory.getLogger("CalcAreaTest.class");

    @Test
    void successSquareCalculation() {
        assertAll(
                () ->assertEquals(TriangleArea.calcArea(5, 6, 10), 11.399013115177997),
                () ->assertTrue(Math.abs(TriangleArea.calcArea(5, 6, 10) - 11) < 0.41),
                () ->assertEquals(11, TriangleArea.calcArea(5, 6, 10), 0.399013115177997)
        );
        logger.info("Успешная проверка площади треугольника");
    }

    @Test
    @DisplayName("Одна сторона треугольника меньше или равна 0")
    void negativeTriangleTest1() {
        assertAll(
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(-2, 3, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, -3, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 3, -4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 0, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(0, 3, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 3, 0))
        );
        logger.info("Одна сторона треугольника меньше или равна 0");
    }

    @Test
    @DisplayName("Одна из сторон треугольника больше или равна сумме двух других строн")
    void negativeTriangleTest2() {
        assertAll(
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(8, 3, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 7, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 3, 6)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(7, 3, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 6, 4)),
                () -> assertThrows(Exception.class, () -> TriangleArea.calcArea(2, 3, 5))
        );
        logger.info("Одна из сторон треугольника больше или равна сумме двух других строн");
    }
}


