import java.util.Arrays;
// two height is same i.e. difference of two supports are zero
//TC : O(N*S) SC: O(N*S)
class Solution {
    private static final int MIN = Integer.MAX_VALUE;
    private static final int offset = 5000;  //diff
    private int ans, n;
    private int[] rods;
    private int[][] dp;

    public int tallestBillboard(int[] rods) {
        this.rods = rods;
        n = rods.length;
        dp = new int[21][2 * offset + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(0, 0);
        return ans < 0 ? 0 : ans;
    }

    private int solve(int i, int diff) {
        if (i == n) {
            if (diff == 0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if (dp[i][diff + offset] != -1) {
            return dp[i][diff + offset];
        }

        int opt1 = solve(i + 1, diff);  //not take it
        int opt2 = rods[i] + solve(i + 1, diff + rods[i]);  //take it in a support a
        int opt3 = solve(i + 1, diff - rods[i]); //take it in a support b

        return dp[i][diff + offset] = Math.max(Math.max(opt1, opt2), opt3);
    }
}
