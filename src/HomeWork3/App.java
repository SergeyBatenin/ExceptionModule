package HomeWork3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    public static void start() {
        System.out.println("Введите ваши данные(ФИО, дату рождения, телефон, пол)");
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        String[] data = null;
        while (!flag) {
            String inputFromUser = scanner.nextLine();
            inputFromUser = inputFromUser.replaceAll("\\s+", " ");
            data = inputFromUser.split(" ");
            int checkInput = isValidInput(data);
            if (checkInput > 0) {
                System.out.println("Вы ввели лишние данные");
            } else if (checkInput < 0) {
                System.out.println("Вы ввели недостаточно данных");
            } else {
                try {
                    User user = createUser(data);
                    //System.out.println(user);
                    writeToFile(user);
                    flag = true;
                } catch (ConvertSexException | ConvertPhoneNumberException | ConvertDateException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static User createUser(String[] data) throws ConvertSexException, ConvertPhoneNumberException, ConvertDateException {
        User user = new User();
        user.setLastName(data[0]);
        user.setFirstName(data[1]);
        user.setMiddleName(data[2]);

        char sex = setSex(data);
        LocalDate birthday = setBirthday(data);
        long phoneNumber = setPhone(data);

        user.setBirthday(birthday);
        user.setPhoneNumber(phoneNumber);
        user.setSex(sex);

        return user;
    }
    private static char setSex(String[] data) {
        char sex = 0;
        for (int i = 3; i < data.length; i++) {
            if ("f".equalsIgnoreCase(data[i])) {
                sex = 'f';
                break;
            } else if ("m".equalsIgnoreCase(data[i])) {
                sex = 'm';
                break;
            }
        }
        if (sex != 'f' && sex != 'm') throw new ConvertSexException("Вы ввели не корректный формат пола");
        return sex;
    }
    private static long setPhone(String[] data) {
        long phoneNumber = -1;
        for (int i = 3; i < data.length; i++) {
            if (isValidPhone(data[i])) {
                phoneNumber = Long.valueOf(data[i]);
                break;
            }
        }
        if (phoneNumber < 0) throw new ConvertPhoneNumberException("Вы ввели не корректный формат номера телефона");
        return phoneNumber;
    }
    private static boolean isValidPhone(String value) {
        boolean result = false;
        try {
            Long.valueOf(value);
            result = true;
        } catch (NumberFormatException e) {
        } finally {
            return result;
        }
    }
    private static LocalDate setBirthday(String[] data) {
        LocalDate localDate = null;
        for (int i = 3; i < data.length; i++) {
            if (isValidBirthday(data[i])) {
                localDate = LocalDate.parse(data[i], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                break;
            }
        }
        if (localDate == null)
            throw new ConvertDateException("Вы ввели не корректный формат даты рождения", "SOME TEXT", 0);
        return localDate;
    }
    private static boolean isValidBirthday(String value) {
        boolean result = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(value, formatter);
            result = true;
        } catch (DateTimeParseException e) {
            //System.out.println(e.getMessage());
        } finally {
            return result;
        }
    }
    private static int isValidInput(String[] arr) {
        int result = 6;
        if (result > arr.length) return -1;
        else if (result < arr.length) return 1;
        else return 0;
    }

    private static void writeToFile(User user) throws IOException {
        String path = "src\\HomeWork3\\" + user.getLastName() + ".txt";
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(user.toString() + "\n");
        fileWriter.flush();
        fileWriter.close();
    }
}
