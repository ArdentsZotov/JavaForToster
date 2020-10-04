package ru.zotov.utils.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        ICalculator calculator = new Calculator();


        calculator.divisionDoubleNumber();
//        ICalculatorSimulation ics = x -> {
//            System.out.println("Choice action:\n1 - summ;\n2 - minus;\n3 - multiplex;\n4 - division;\n5 - search max long word.");
//            try {
//                double result=0;
//                switch (new Scanner(System.in).nextInt()) {
//                    case (1):
//                        result = x.sumDoubleNumber();
//                        break;
//                    case (2):
//                        result = x.minusDoubleNumber();
//                        break;
//                    case (3):
//                        result = x.multiplexDoubleNumber();
//                        break;
//                    case (4):
//                        result = x.divisionDoubleNumber();
//                        break;
//                    case (5):
//                        //независимо от реализации ICalculator выполняется статичный метод класса Calculator
//                        Calculator.searchLongWord();
//                        break;
//                }
//                System.out.println(result);
//            } catch (InputMismatchException exp) {
//                System.out.println("=(");
//            }
//
//        };
//
//        ics.startSimulation(calculator);

    }
}

