/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 *
 * https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/
 *
 * algorithms
 * Easy (58.52%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    46.4K
 * Total Submissions: 79.4K
 * Testcase Example:  '"ABCABC"\n"ABC"'
 *
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 由大写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
            // 当子串长度能被两个字符串除尽时才可能是公因子
            if (len1 % i == 0 && len2 % i == 0) {
                // 取子串
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    // check函数功能：公因子t自身连接1次或多次是否等于字符串
    public boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }
}
// @lc code=end
