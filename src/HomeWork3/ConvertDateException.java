package HomeWork3;

import java.time.format.DateTimeParseException;

public class ConvertDateException extends DateTimeParseException {
    public ConvertDateException(String msg, CharSequence cs, int i) {
        super(msg, cs, i);
    }
}
