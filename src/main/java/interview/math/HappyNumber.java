package interview.math;

import utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/8.
 */
public class HappyNumber {
    public static void main(String[] args) {
        Printer.print(isHappy(12));
    }

    public static boolean isHappy(int n) {
        List<Integer> loop = new ArrayList<>();
        while(true){
            int cur = 0;

            while(n>0){
                cur += (n%10) * (n%10);
                n /= 10;
            }

            if(cur==1){
                return true;
            }else if(loop.indexOf(cur)!=-1){
                return false;
            }else{
                loop.add(cur);
                n = cur;
            }
        }
    }
}
