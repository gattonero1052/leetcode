package others;

import utils.Printer;

import java.util.Arrays;

/**
 * Created by zly on 2018/2/24.
 * 有个很巧妙的On解法
 *
 * 这里其实并不是dp，因为每一步的dp结果的意义和最终的dp结果意义是不同的（即不存在dp递推式）
 * 题目只规定了整个数组中，majority出现的次数，对于每一步而言，并没有求出当前步骤的majority（有可能不存在）
 *
 * 我们可以反证这个算法的正确性，假如对于数组a1-n，majority的值是m，算法计算的结果是p并且m不等于p
 *
 * 那么 majority = p 赋值的位置后（不包括赋值的位置），显然m的数量不可能超过p的数量
 * 所以在赋值前（包括赋值的位置），m的值一定超过半数（前后都不超过半数，不可能总数超过半数），所以对于这一段来说，计算的结果也是错误的
 *
 *
 * https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
 */
public class MajorityElement {
    public static void main(String[] args) {
        Printer.print(majorityElement2(new int[]{
                2,2,4,3,3,3,2,2,4,2,2,4
        }));
    }

    public static int majorityElement2(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
        }
        return major;
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
