package de.sdm.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PriceUtilsTest {

    @Test
    void testCalculatePrice() {
        assertEquals(BigDecimal.valueOf(13.99),
                PriceUtils.calculatePrice(BigDecimal.valueOf(5.99), BigInteger.valueOf(80)));
        assertEquals(BigDecimal.valueOf(11.99),
                PriceUtils.calculatePrice(BigDecimal.valueOf(5.99), BigInteger.valueOf(60)));
        assertEquals(BigDecimal.valueOf(9.99),
                PriceUtils.calculatePrice(BigDecimal.valueOf(5.99), BigInteger.valueOf(40)));
    }
}