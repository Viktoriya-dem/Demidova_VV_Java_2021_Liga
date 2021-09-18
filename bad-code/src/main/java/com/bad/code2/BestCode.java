package com.bad.code2;

import com.bad.code2.figure.Cube;
import com.bad.code2.figure.Square;

public class BestCode {
    public static void main(String... args) {
        Cube cube = new Cube(1d, 1d, 1d, 10d);
        System.out.println("Cube volume: " + cube.getVolume());

        Square square = new Square(1d, 1d, 5d);
        System.out.println("Square perimeter: " + square.getPerimeter());
    }

}
