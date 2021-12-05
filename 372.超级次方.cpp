/*
 * @lc app=leetcode.cn id=372 lang=cpp
 *
 * [372] 超级次方
 *
 * https://leetcode-cn.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (50.77%)
 * Likes:    220
 * Dislikes: 0
 * Total Accepted:    29.7K
 * Total Submissions: 52.6K
 * Testcase Example:  '2\n[3]'
 *
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：a = 2, b = [3]
 * 输出：8
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 0 
 * b 不含前导 0
 * 
 * 
 */

// 快速幂
// (a⋅b) mod m=[(a mod m)⋅(b mod m)] mod m

// @lc code=start
class Solution {
    const int MOD = 1337;

    int pow(int x, int n) {
        int res = 1;
        while (n) {
            if (n % 2) {
                res = (long) res * x % MOD;
            }
            x = (long) x * x % MOD;
            n /= 2;
        }
        return res;
    }

public:
    int superPow(int a, vector<int> &b) {
        int ans = 1;
        for (int i = b.size() - 1; i >= 0; --i) {
            ans = (long) ans * pow(a, b[i]) % MOD;
            a = pow(a, 10);
        }
        return ans;
    }
};

// @lc code=end

