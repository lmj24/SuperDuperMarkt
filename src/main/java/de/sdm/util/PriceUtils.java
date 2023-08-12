package de.sdm.util;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;


@NoArgsConstructor
public class PriceUtils {

    public static BigDecimal calculatePrice(BigDecimal basePrice, BigInteger quality) {
        return BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(quality.doubleValue())).add(basePrice);
    }
}
