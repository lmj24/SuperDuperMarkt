package de.sdm.util;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
public class DateUtils {

    public static String getExpirationDate(LocalDate expirationDate, DateTimeFormatter formatter) {
        if (expirationDate != null)
            return expirationDate.format(formatter);
        else
            return "-";
    }
}
