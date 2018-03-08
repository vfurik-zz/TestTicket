package ua.tickets.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class DateHelper {

    public static String getDate(int monthDiff){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.plusMonths(monthDiff).format(dateTimeFormatter);
    }

    public static LocalDate getRandomDate(LocalDate minDate, LocalDate maxDate){
        long minDay = minDate.toEpochDay();
        long maxDay = maxDate.toEpochDay();
        long randomDate = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDate);
    }
}
