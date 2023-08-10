package de.sdm.util;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculationUtilsTest {

    @Test
    public void testcalculateWineQuality() {
        assertEquals(BigInteger.valueOf(45),
                CalculationUtils.calculateWineQuality
                        (BigInteger.valueOf(40), LocalDate.of(2023, 8, 10),
                                LocalDate.of(2023, 9, 29)));
        assertEquals(BigInteger.valueOf(43),
                CalculationUtils.calculateWineQuality
                        (BigInteger.valueOf(40), LocalDate.of(2023, 8, 10),
                                LocalDate.of(2023, 9, 12)));
        assertEquals(BigInteger.valueOf(-11),
                CalculationUtils.calculateWineQuality
                        (BigInteger.valueOf(-20), LocalDate.of(2023, 8, 10),
                                LocalDate.of(2023, 11, 17)));

    }
}