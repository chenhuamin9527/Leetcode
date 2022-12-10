/*
 * @lc app=leetcode.cn id=415 lang=cpp
 *
 * [415] 字符串相加
 *
 * https://leetcode.cn/problems/add-strings/description/
 *
 * algorithms
 * Easy (54.96%)
 * Likes:    647
 * Dislikes: 0
 * Total Accepted:    242.6K
 * Total Submissions: 441.4K
 * Testcase Example:  '"11"\n"123"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= num1.length, num2.length <= 10^4
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    string addStrings(string num1, string num2) {
        string ans = "";
        int n1=num1.size()-1, n2 = num2.size()-1, add = 0;
        while(n1 >= 0 || n2 >= 0 || add != 0)
        {
            int a = n1 >= 0 ? num1[n1] - '0' : 0;
            int b = n2 >= 0 ? num2[n2] - '0' : 0;
            int result = a + b + add;
            ans.push_back('0' + result % 10);
            add = result / 10;
            n1 -= 1;
            n2 -= 1;
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};
// @lc code=end

