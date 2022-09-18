package HomeWork2;

import java.util.Scanner;

/*
* Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
* Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/
public class Task4 {
    public static void main(String[] args) {
        String result = null;
        try {
            result = inputFromUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Вы ввели: \"" + result + "\"");
    }

    private static String inputFromUser() throws Exception {
        String result;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        result = scanner.nextLine();
        if (result.isEmpty()) {
            throw new Exception("Нельзя вводить пустые строки");
        }
        return result;
    }
}
