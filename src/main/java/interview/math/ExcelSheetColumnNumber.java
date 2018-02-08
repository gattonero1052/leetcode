package interview.math;

import utils.Printer;

/**
 * Created by zly on 2018/2/8.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Printer.print(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i <chars.length ; i++) {
            sum*=26;
            sum+=chars[i]-64;
        }

        return sum;
    }
}
