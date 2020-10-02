package ru.zotov.utils.calculator;

import org.apache.commons.math3.util.Precision;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator implements ICalculator {

    public Calculator() {}

    public Double sumDoubleNumber() {
        double firstNumber = inputDoubleNumber();
        double secondNumber = inputDoubleNumber();
        return Precision.round(firstNumber + secondNumber, 3);
    }

    private double inputDoubleNumber() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        } catch (InputMismatchException exp) {
            return inputDoubleNumber();
        }
    }
}
