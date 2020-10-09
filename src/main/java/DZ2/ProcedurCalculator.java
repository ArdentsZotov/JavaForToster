package DZ2;

import ru.zotov.utils.calculator.Calculator;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcedurCalculator {
    public static void main(String[] args) {

        final String startMessage = "Выбор операции:\n" + "[1] - Калькулятор;\n" +
                "[2] - Поиска максимально длинного введенного слова;\n" + "[Q] - Выход.";

        final String calcMessage = "Выберите математическую операцию:\n[1] - сумма;\n[2] - вычитание;\n[3] - умножение;\n[4] - деление;\n" +
                "[5] - возведение в степень N.";

        System.out.println(startMessage);

        char selector;
        String stringLine;
        Scanner scanner;

        do {
            // выполнять до тех пора, пока не придет валидное значение
            scanner = new Scanner(System.in);
            stringLine = scanner.nextLine();
            selector = stringLine.length() == 1 ? stringLine.charAt(0) : '0';
        } while (selector != '1' && selector != '2' && selector != 'Q' && selector != 'q');

        if (selector == 'q' || selector == 'Q') System.exit(0);

        if (selector == '2') {
            System.out.println("Операция \"Поиск максимально длинной строки из введенных\"");
            Calculator.searchLongWord();
            System.exit(0);
        }

        {
            System.out.println("Операция \"Калькулятор\"");
            System.out.println(calcMessage);

            int selectorOperation = -1;
            try {
                selectorOperation = new Scanner(System.in).nextInt();
                if (selectorOperation < 1 || selectorOperation > 5) throw new InputMismatchException();
            } catch (InputMismatchException exp) {
                exp.printStackTrace();
                System.out.println("Недопустимое значение. Завершение программы.");
                System.exit(0);
            }

            System.out.printf("Выбрана операций %d. Введите значения:", selectorOperation);

            double num1;
            double num2;

            try {
                DecimalFormat df = new DecimalFormat("#.####");
                System.out.println();
                num1 = new Scanner(System.in).nextDouble();
                num2 = new Scanner(System.in).nextDouble();

                switch (selectorOperation) {
                    case (1):
                        System.out.printf("Сумма чисел %.4f и %.4f равняется " +df.format(num1 + num2), num1, num2);
                        break;
                    case (2):
                        System.out.printf("Разность чисел %.4f и %.4f равняется " + df.format(num1 - num2), num1, num2);
                        break;
                    case (3):
                        System.out.printf("Произведение чисел %.4f и %.4f равняется " + df.format(num1 * num2), num1, num2);
                        break;
                    case (4):
                        if (num2 == 0) throw new ArithmeticException();
                        System.out.printf("Результат деления числа %.4f на %.4f равняется " + df.format(num1 / num2), num1, num2);
                        break;
                    case (5):
                        System.out.printf("Число %.4f в степени %.4f равняется " + df.format(Math.pow(num1, num2)), num1, num2);
                        break;
                }
            } catch (InputMismatchException exp) {
                exp.printStackTrace();
                System.out.println("Недопустимое значение.");
            } catch (ArithmeticException exp1) {
                exp1.printStackTrace();
                System.out.println("Деление на нуль.");
            } finally {
                System.out.print("\nЗавершение программы.");
                System.exit(0);
            }
        }
    }
}
