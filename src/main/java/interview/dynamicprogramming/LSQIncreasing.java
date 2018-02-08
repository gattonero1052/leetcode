package interview.dynamicprogramming;

import utils.Printer;

/**
 * Created by zly on 2018/2/8.
 * LSQ means longest subsequence
 * O(n2)
 *
 * 题目没说相等算不算 increasing，这里应该是不算的
 */
public class LSQIncreasing {
    public static void main(String[] args) {
        Printer.print(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //On2
    public static int lengthOfLIS(int[] nums) {
        int res = 0,dp[] = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }

            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
