package interview.math;

import utils.Printer;

/**
 * Created by zly on 2018/2/8.
 要求在对数时间内解决问题
 分解质因数就行
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Printer.print(trailingZeroes(1));
        Printer.print(1*2*3*4*5*6*7*8*9*10);
    }

    public static int trailingZeroes(int n) {
        int two = 0,five = 0,count,start;

        //two
        start = n;
        count = 1;
        while(start>0){
            start/=2;
            two+=count*start;
        }

        //five
        start = n;
        count = 1;
        while(start>0){
            start/=5;
            five+=count*start;
        }

        return Math.min(two,five);
    }
}
