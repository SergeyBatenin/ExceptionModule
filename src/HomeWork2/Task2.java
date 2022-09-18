package HomeWork2;

/*
 * посмотреть и изменить код
   try {
      int d = 0;
      double catchedRes1 = intArray[8] / d;
      System.out.println("catchedRes1 = " + catchedRes1);
   } catch (ArithmeticException e) {
      System.out.println("Catching exception: " + e);
   }
 */
public class Task2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 0, 3, 7, 6, 4};
        try {
            // а еще не знаю на сколько критично, но я бы эту переменную тогда сделал double
            // либо массив выше типа double, потмоу что иначе при делении целого на целое у нас будет
            // происходить целочисленное деление и уже результат(целочисленный) записываться в переменную типа double
            int d = 0;
            // Как я понял изначально должен быть создан массив и судя по названию целочисленный
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
            // также добавляем блок который будет следить, чтобы не было выхода за пределы массива
        } catch (IndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
