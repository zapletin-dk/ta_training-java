package com.epam.rd.autotasks.max;

import java.util.OptionalInt;
public class MaxMethod {
    public static OptionalInt max (int[] values) {
        if (values != null && values.length > 0) {
            int maxValue = values[0];
            for (int i = 1; i < values.length; i++) {
                if (values[i] > maxValue) maxValue = values[i];
            }
            return OptionalInt.of(maxValue);
        } else return OptionalInt.empty();
    }
}
