package interview.dynamicprogramming;

/**
 * Created by zly on 2018/2/8.
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(i!=0||j!=0)
                    dp[i][j] = (i>0?dp[i-1][j]:0) + (j>0?dp[i][j-1]:0);
        return dp[m-1][n-1];
    }
}
