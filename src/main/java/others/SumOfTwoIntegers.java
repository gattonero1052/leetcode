package others;

import utils.Printer;

/**
 * Created by zly on 2018/2/24.
 * 10100
 * 11110
 *
 * 参考了这个作者 lid004 的想法
 * https://leetcode.com/problems/sum-of-two-integers/discuss/84283/0ms-AC-java-solution?page=3
 *
 * 思路：如果两个数a，b相加时不需要进位，那么a&b==0，而且a^b==a+b
 * 使用了整体异或获取原始值，整体与并且左移获取进位值，然后将原始值和进位值相加的操作，直到进位值为0时，表示不需要进位
 * 因为左移后末尾一定是0，所以不会出现无穷递归，最差时间复杂度为logn（a=2**n-1，b=1时）
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Printer.print(getSum(2147483647, 1));
        System.out.println(count);
    }

    static int count = 0;
    public static int getSum2(int a, int b) {
        return a+b;
    }
    public static int getSum(int a, int b) {
        count++;
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
