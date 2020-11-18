public class Solution {
    //s为传入的字符串
    public int minCut(String s) {
        //统计传入字符串S的字符个数
        int n = s.length();
        //状态定义：judge(i, j) -------- 字符串s中[i, j]范围内的子串是否是回文串
        boolean[][] judge = new boolean[n][n];
        //状态定义：dp[i]表示s中第i个字符到第（n-1）个字符所构成的子串的最小分割次数
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            //初始化：子串的最小分割次数dp[i]
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || judge[i + 1][j - 1])) {
                    judge[i][j] = true;
                    if (j + 1 < n) {
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                    }else{
                        dp[i] = 0;
                    }
                }
            }
        }
        return dp[0];
    }
}


