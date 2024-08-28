package com.chud.ntm.lib;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class Library {

    public static Map<Integer, String> numbersMap = new TreeMap<>();

    static {
        numbersMap.put(3, "k");
        numbersMap.put(6, "M");
        numbersMap.put(9, "G");
        numbersMap.put(12, "T");
        numbersMap.put(15, "P");
        numbersMap.put(18, "E");
        numbersMap.put(21, "Z");
        numbersMap.put(24, "Y");
        numbersMap.put(27, "R");
        numbersMap.put(30, "Q");
    }

    public static final int[] powersOfTen = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

    public static DecimalFormat numberformat = new DecimalFormat("0.00");

    public static float roundFloat(float number, int decimal) {
        return (float) (Math.round(number * powersOfTen[decimal]) / (float) powersOfTen[decimal]);
    }

    public static float roundFloat(double number, int decimal) {
        return (float) (Math.round(number * powersOfTen[decimal]) / (float) powersOfTen[decimal]);
    }

    public static String getShortNumber(BigDecimal l) {
        boolean negative = l.signum() < 0;

        if(negative){
            l = l.negate();
        }

        String result = l.toPlainString();
        BigDecimal c = null;
        for(Map.Entry<Integer, String> num : numbersMap.entrySet()){
            c = new BigDecimal("1E"+num.getKey());
            if(l.compareTo(c) >= 0){
                double res = l.divide(c).doubleValue();
                result = numberformat.format(roundFloat(res, 2)) + num.getValue();
            } else {
                break;
            }
        }

        if (negative){
            result = "-"+result;
        }

        return result;
    }

    public static String getShortNumber(long l) {
        return getShortNumber(new BigDecimal(l));
    }

}
