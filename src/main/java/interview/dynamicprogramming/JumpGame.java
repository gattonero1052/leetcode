package interview.dynamicprogramming;

import utils.Printer;

/**
 * Created by zly on 2018/2/8.
 * 用原数组前一位保存dp结果就行了
 */
public class JumpGame {
    public static void main(String[] args) {
        Printer.print(canJump(new int[]{0}));
        Printer.print(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]<1)
                return false;
            nums[i] = Math.max(nums[i-1]-1,nums[i]);
        }
        return true;
    }
}
