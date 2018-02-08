package interview.math;

import utils.Printer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zly on 2018/2/8.
 * 要考虑负数
 */

public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
        Printer.print(fractionToDecimal(-2147483648,10));
        Printer.print(fractionToDecimal(111,7));
        Printer.print(fractionToDecimal(-50,8));
        Printer.print(fractionToDecimal(1,99));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = numerator!=0 && (numerator>0^denominator>0);

        long numeratorl = Math.abs((long)numerator),denominatorl = Math.abs((long)denominator);

        Map<Long,Integer>[] maps = new HashMap[10];//key:remain value:index
        int end = 0;

        StringBuilder res = new StringBuilder(String.valueOf(numeratorl/denominatorl));
        numeratorl=(numeratorl%denominatorl)*10;

        for (int i = 0; i < 10; i++) {
            maps[i] = new HashMap<>();
        }


        if(numeratorl!=0){
            res.append('.');
            end=1;
        }

        while(numeratorl!=0){

            while(numeratorl<denominatorl){//一开始补0
                numeratorl*=10;
                res.append('0');
                end++;
            }

            int cur = (int)(numeratorl/denominatorl);
            if(maps[cur].containsKey(numeratorl)){
                //找到循环节
                res.insert(res.indexOf(".")+maps[cur].get(numeratorl),"(");
                res.append(')');
                break;
            }else{
                maps[cur].put(numeratorl,end);
            }
            res.append(cur);
            numeratorl = (numeratorl%denominatorl)*10;
            end++;
        }

        return isNegative?"-"+res.toString():res.toString();
    }
}
