package ru.zotov.utils.calculator;

import org.apache.commons.math3.util.Precision;

import java.util.InputMismatchException;
import java.util.Scanner;

//* Могу) */
public class Calculator implements ICalculator {

    public Calculator() {
    }

    public Double sumDoubleNumber() {
        return Precision.round(inputDoubleNumber() + inputDoubleNumber(), 4);
    }

    public Double minusDoubleNumber() { return Precision.round(inputDoubleNumber() - inputDoubleNumber(), 4); }

    public Double multiplexDoubleNumber() {
        return Precision.round(inputDoubleNumber() * inputDoubleNumber(), 4);
    }

    public Double divisionDoubleNumber() {
        return Precision.round(inputDoubleNumber() / inputDoubleNumber(), 4);
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

            if (newWord.length()>lengthWord) {
                word = newWord;
                lengthWord = newWord.length();
            }
        }
        while (true);
    }

}
