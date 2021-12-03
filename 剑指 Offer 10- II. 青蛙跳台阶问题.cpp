class Solution {
public:
    int numWays(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 3;
        vector<int> dp(n+1,1);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++)
        {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;

        }
        return dp[n];
    }
}; 