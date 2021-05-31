package com.huramkin.definite_integral_calculation;
/*
微积分:定积分功能实现部分
 */

import com.huramkin.math_function.Function;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class DefiniteIntegralCalculation {
    /**
     *
     * @param dupper DefiniteIntegralCalculation Upper
     * @param dlower DefiniteIntegralCalculation Lower
     * @param dstep DefiniteIntegralCalculation Cutting interval
     *
     * @return result
     */
    public  static String definiteIntegralCalculation(Function function, double dupper, double dlower, double dstep) {
        BigDecimal upper = new BigDecimal(dupper);//上限
        BigDecimal lower = new BigDecimal(dlower);//下限
        BigDecimal step = new BigDecimal(dstep);//间隔
        BigDecimal piece = upper.subtract(lower).divide(step,100,RoundingMode.HALF_UP);//分为4片,保留100位小数
        //System.out.println(piece);
        BigDecimal[] x = new BigDecimal[piece.add(new BigDecimal(1)).intValue()];//定义x的数组长度
        x[0] = lower;
        x[x.length - 1] = upper;
        BigDecimal forwordStep = new BigDecimal(0);
        for (int i = 1; i < x.length - 1; i++) {
            forwordStep = forwordStep.add(step);
            x[i] = forwordStep;
        }

        //BigDecimal[] y = mathFun(x);
        BigDecimal[] y = function.mathFun(x);
        //odd&even
        BigDecimal odd = new BigDecimal(0);//奇数处理
        BigDecimal even = new BigDecimal(0);
        for (int i = 0; i < y.length; i++) {
            if (i % 2 == 0 && i != 0){//evennumber
                even = even.add(y[i]);
            }else if(i % 2 == 1 && i != upper.intValue()){
                odd = odd.add(y[i]);
                //System.out.println("for odd"+y[i]);
            }
        }
        //System.out.println("乘法运算前"+odd);
        BigDecimal odd_deal = odd.multiply(new BigDecimal(4));
        BigDecimal even_deal = even.multiply(new BigDecimal(2));
        BigDecimal oddeven = odd_deal.add(even_deal).add(y[0]).add(y[x.length -1 ]);
        //System.out.println(oddeven+" "+even_deal+" "+oddeven);
        BigDecimal para =  step.multiply(oddeven).divide(new BigDecimal(3),5,RoundingMode.HALF_UP);
        //System.out.println("积分结果是 "+para);
        String definiteIntegralCalculation_result = para.toString();
        return definiteIntegralCalculation_result;

    }

    /* static BigDecimal[] mathFun(BigDecimal[] x){//Funcation示例
        BigDecimal[] y = new BigDecimal[x.length];
        for (int i = 0; i < x.length; i++) {//函数书写给y赋值部分
            double temp = 0;
            temp = Math.pow(x[i].doubleValue(),9);
            temp = temp+x[i].doubleValue();
            y[i] = new BigDecimal(temp) ;//为函数y=x^2+x批量赋值
        }
        return y;
    }*/
}

