package extras;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DatesAndTimes {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        Instant instant = Instant.now();
        Date date = new Date();
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.now();

        System.out.println("Date: " + date);
        System.out.println("LocalDate: " + ld);
        System.out.println("LocalTime: " + lt);
        System.out.println("LocalDateTime: " + ldt);
        System.out.println("ZonedDateTime: " + zdt);
        System.out.println("Instant: " + instant);
        System.out.println("Date: " + date);
        // Get year, month, and day from the date object
        int YEAR = ldt.getYear();
        int MONTH = ldt.getMonthValue();
        int DAY = ldt.getDayOfMonth();
        System.out.println("LocalDateTime YEAR: " + YEAR);
        System.out.println("LocalDateTime MONTH: " + MONTH);
        System.out.println("LocalDateTime DAY: " + DAY);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = ld.format(formatter);
        System.out.println(formattedDate);
    }
}

