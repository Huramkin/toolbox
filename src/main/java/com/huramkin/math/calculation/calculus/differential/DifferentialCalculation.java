package com.huramkin.math.calculation.calculus.differential;

import com.huramkin.math.function.Function;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DifferentialCalculation {
    public static String differentialCalculation(Function function, double point,double step){
        BigDecimal pointDec = new BigDecimal(point);
        BigDecimal stepDec = new BigDecimal(step);
        BigDecimal pointDecPlus = pointDec.add(stepDec);
        BigDecimal[] x = new BigDecimal[2];
        x[0] = pointDec;
        x[1] = pointDecPlus;
        BigDecimal[] y = function.mathFun(x);
        BigDecimal subtracty = y[0].subtract(y[1]);
        BigDecimal subtractx = x[0].subtract(x[1]);
        BigDecimal divide = subtracty.divide(subtractx, 5, RoundingMode.HALF_UP);
        String s = divide.toString();
        return s;
    }
}
