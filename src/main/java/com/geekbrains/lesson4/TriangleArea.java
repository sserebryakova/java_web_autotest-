package com.geekbrains.lesson4;

public class TriangleArea {
        public static double calcArea(double A, double B, double C) throws Exception {
            if (A <= 0 || B <= 0 || C <= 0) throw new Exception("Одна сторона треугольника меньше или равна 0");
            if (A + B <= C || B + C <= A || A + C <= B)
                throw new Exception("Одна из сторон треугольника больше или равна сумме двух других строн");
            double halfP = (A + B + C) / 2;
            double square = (halfP * (halfP - A) * (halfP - B) * (halfP - C));
            return Math.sqrt(square);
        }
    }


