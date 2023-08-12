package de.sdm.util;

import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@NoArgsConstructor
public class CalculationUtils {

    public static BigInteger calculateWineQuality(BigInteger quality, LocalDate now, LocalDate date) {
        long difference = ChronoUnit.DAYS.between(now, date);
        int factor = (int) Math.floor(difference / 10.0);
        BigInteger result = quality.add(BigInteger.valueOf(factor));

        return result;
    }

    public static BigInteger calculateCheese(BigInteger quality, LocalDate now, LocalDate date) {
        long difference = ChronoUnit.DAYS.between(now, date);
        BigInteger result = quality.subtract(BigInteger.valueOf(difference));
        return result;
    }
}
