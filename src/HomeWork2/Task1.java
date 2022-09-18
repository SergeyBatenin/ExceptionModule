package HomeWork2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static void main(String[] args){
        float number = inputFromUser();
        System.out.println("Вы ввели " + number);
    }

    private static float inputFromUser(){
        float result = -1;
        System.out.println("Введите число с плавающей точкой(через запятую!)");
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            try {
                result = scanner.nextFloat();
                flag = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Вы ввели не число. Повторите ввод");
            }
        }
        scanner.close();
        return result;
    }
}
