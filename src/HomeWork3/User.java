package HomeWork3;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private char sex;
    private long phoneNumber;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    private String formatBirthday() {
        String[] date = String.valueOf(this.birthday).split("-");
        return new StringBuilder().append(date[2])
                .append(".")
                .append(date[1])
                .append(".")
                .append(date[0])
                .toString();
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "<" +
                lastName +
                "><" + firstName +
                "><" + middleName +
                "><" + formatBirthday() +
                "><" + phoneNumber +
                "><" + sex +
                '>';
    }
}
