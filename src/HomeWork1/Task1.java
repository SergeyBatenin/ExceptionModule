package HomeWork1;

import java.util.Scanner;

/*
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */
public class Task1 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Вариант №1");
        divide(10, 2);
        divide(10, 0);
        System.out.println();
        System.out.println("Вариант №2");
        setValue(1, 0);
        setValue(1, 100);
        System.out.println();
        System.out.println("Вариант №3");
        createStringAndShowLength();
        System.out.println();
        System.out.println("Вариант №4");
        convertStringToInt();
        System.out.println();
        System.out.println("Вариант №5");
        convertObjectToInt();
        sc.close();
    }

    private static void convertObjectToInt() {
        try {
            Object obj = "5";
            int number = (int) obj;
            System.out.println("Number = " + number);
        } catch (ClassCastException e) {
            System.out.println("\nНеверный тип данных. Преобразование к числу невозможно.");
        }
    }

    private static void convertStringToInt() {
        try {
            System.out.print("Введите текст: ");
            String str = sc.nextLine();
            //String str = "10e2";
            int number = Integer.parseInt(str);
            System.out.println("Number = " + number);
        } catch (NumberFormatException e) {
            System.out.println("\nНеверный формат числа");
        }
    }

    private static void createStringAndShowLength() {
        try {
            System.out.print("Введите текст: ");
            String result = sc.nextLine();
            //String result = null;
            System.out.println(result.length());
        } catch (NullPointerException e) {
            System.out.println("Строка равна null. Нельзя вызвать метод length()");
        }
    }

    private static void setValue(int value, int index) {
        int[] array = new int[10];
        try {
            array[index] = value;
            System.out.println("Значение успешно занесено в элемент массива");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }
    }

    public static void divide(int x, int y) {
        try {
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            System.out.println("Попытка деления на 0");
        }
    }
}
