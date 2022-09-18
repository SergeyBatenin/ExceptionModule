package HomeWork2;

import java.io.FileNotFoundException;

/*
* посмотреть и исправить код при необходимости
*/
public class Task3 {
    // Нет смысла указывать после метода выброс Exception так как в коде есть блок catch, в котором
    // обрабатывается родоначальник всех исключений Throwable
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException e) { // так как у нас есть деление, то можно добавить исключение ArithmeticException
            System.out.println("Попытка деления на 0");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
            // Это исключение было самым первым, следовательно так как оно является родителем
            // вообще всех исключений, то остальные никогда бы не были достигнуты
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    // По идее этот метод не работает с файлами и ему не нужно это исключение
    // Да и по идее вообще никаких
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
}
