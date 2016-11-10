package it.csttech.recruitment.data.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExpUtils
{
    static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    static double logOfBase(int base, double num) {
        return Math.log(base) / Math.log(num);
    }
}
