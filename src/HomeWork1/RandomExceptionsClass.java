package HomeWork1;

//package java1.lessonsforqa.lesson1; // Исправлен пакет

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class RandomExceptionsClass {
    public static void main(String[] args) throws IOException {
        callMethod6("");
        ArrayList<String> stringArraysList = (ArrayList<String>) callMethod1();
        int a=10, b=0;
        callMethod6("");
        int div = callMethod2(a, b);
        System.out.println(div);
        callMethod6("");
        callMethod3(stringArraysList);
    }

    private static void callMethod6(String s) { // как одно из предложений можно убрать аргументы метода
        System.out.println("Hello World, it's me!"); // так как они не используются для работы метода
    }

    private static void callMethod3(ArrayList<String> stringArraysList) {
        //Метод является рекурсивным, но в нем не описан базовый случай
        // поэтому закомментировал строчку где метод  вызывает сам себя
        // чтобы он писал приветствие миру однократно
        callMethod6("");
        //callMethod3(stringArraysList);
    }

    private static Collection<String> callMethod1() throws IOException {
        callMethod2(100000000, 10-10);
        // return new LinkedList<>(); LinkedList нельзя привести к типу ArrayList. Либо менять тип коллекции в методе main
        // либо менять в данном методе тип возвращаемой коллекции, что я и сделал
        return new ArrayList<>();
    }

    public static int callMethod2(int a, int b) throws IOException, ArithmeticException {
        callMethod6("");                                 // Создал файл и исправил путь к нему
        FileInputStream fis = new FileInputStream("src\\HomeWork1\\1.txt");
        fis.read();

        if(fis.available() > 0) throw new RuntimeException(); // файл оставил пустым, чтобы не было выброса исключения
        int num = callMethod4("1240"); // Вместо цифры "0" была буква "O"
        // Перепишу часть ниже обрамленную многострочным комментарием
        /* return a/b; */
        // Вариант 1
//        int errorCode = -1;
//        return b == 0 ? errorCode : a/b;
        // Вариант 2  В этом варианте будет на 1 уведомление больше в консоли
        int result = -1;
        try {
            result = a/b;
        } catch (ArithmeticException e) {
            System.out.println("Была попытка деления на 0. Будет возвращен код ошибки -1");
        } finally {
            return result;
        }
    }

    private static int callMethod4(String s) {
        callMethod5(s);
        return Integer.parseInt(s);
    }

    private static void callMethod5(String s) {
        callMethod6("");
        String[] strings = new String[5];        // инициализировал i => 0 заместо 1
        for (int i = 0; i < strings.length; i++){ // сделал строгое неравенство убрав "="
            strings[i] = s;
        }
    }
}