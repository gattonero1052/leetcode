package interview.dynamicprogramming;

import utils.Printer;

/**
 * Created by zly on 2018/2/8.
 */
public class CoinChange {
    public static void main(String[] args) {
//        Printer.print(coinChange(new int[]{1,2,5},11));
        Printer.print(coinChange(new int[]{},3));
    }

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++)
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]);
                }

            if(dp[i]!=Integer.MAX_VALUE)
                dp[i]++;
        }

        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}
