package ru.zotov.utils.dz4;

import java.util.Arrays;

public class TestDZ4 {

    private static void fillMassiv(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = -10 + (int) (Math.random() * 20);
        }
    }

    private static int searchIndexMinPositive(int[] mas) {
        int maxValue = getMax(mas);
        int position = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 0 && mas[i] < maxValue) {
                maxValue = mas[i];
                position = i;
            }
        }
        return position;
    }

    private static int searchIndexMaxNegative(int[] mas) {
        int minValue = getMin(mas);
        int position = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 0 && mas[i] > minValue) {
                minValue = mas[i];
                position = i;
            }
        }
        return position;
    }

    private static int getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    private static int getMin(int[] inputArray) {
        int minValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < minValue) {
                minValue = inputArray[i];
            }
        }
        return minValue;
    }

    private static void replaceTwoElem(int[] mas, int positionMaxNeg, int positionMinPos) {
        int saveValue = mas[positionMaxNeg];
        mas[positionMaxNeg] = mas[positionMinPos];
        mas[positionMinPos] = saveValue;
    }

    public static void main(String[] args) {

        int lengthMas = 20;
        int[] mas = new int[lengthMas];

        fillMassiv(mas);

        int positionMinPos = searchIndexMinPositive(mas);
        int positionMaxNeg = searchIndexMaxNegative(mas);

        //для проверки
        int[] masCheck = new int[mas.length];
        for (int i =0; i<mas.length;i++)
            masCheck[i] = mas[i];

        replaceTwoElem(mas, positionMaxNeg, positionMinPos);

        for (int i =0; i<mas.length;i++) {
            System.out.print(masCheck[i]+" ");
        }
        System.out.println();
        for (int i =0; i<mas.length;i++) {
            System.out.print(mas[i]+" ");
        }
    }
}
