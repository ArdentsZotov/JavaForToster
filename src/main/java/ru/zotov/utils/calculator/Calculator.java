package ru.zotov.utils.calculator;

import org.apache.commons.math3.util.Precision;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator implements ICalculator {

    public Calculator() {
    }

    public Double sumDoubleNumber() {
        return Precision.round(inputDoubleNumber() + inputDoubleNumber(), 4);
    }

    public Double minusDoubleNumber() {
        return Precision.round(inputDoubleNumber() - inputDoubleNumber(), 4);
    }

    public Double multiplexDoubleNumber() {
        return Precision.round(inputDoubleNumber() * inputDoubleNumber(), 4);
    }

    public Double divisionDoubleNumber() {
        double num1 = inputDoubleNumber();
        double num2 = inputDoubleNumber();
        if (num2 == 0) throw new ArithmeticException();
        return num1 / num2;
    }

    public Double sumDoubleNumber(double num1, double num2) {
        return num1 + num2;
    }

    public Double minusDoubleNumber(double num1, double num2) {
        return num1 - num2;
    }

    public Double multiplexDoubleNumber(double num1, double num2) {
        return num1 * num2;
    }

    public Double divisionDoubleNumber(double num1, double num2) {
        if (num2 == 0) throw new ArithmeticException();
        return num1 / num2;
    }

    private double inputDoubleNumber() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        } catch (InputMismatchException exp) {
            return inputDoubleNumber();
        }
    }

    /**
     * Поиск максимально длинного слова из введенных;
     * Пробельный символ " " не является разделителем слов;
     */
    public static void searchLongWord() {
        int lengthWord = 0;
        String word = "";
        System.out.println("Для выхода введите Q");
        do {

            String newWord = new Scanner(System.in).nextLine();

            if (newWord.equals("Q")) {
                System.out.println(word);
                return;
            }

            if (newWord.length() > lengthWord) {
                word = newWord;
                lengthWord = newWord.length();
            }
        }
        while (true);
    }

}
