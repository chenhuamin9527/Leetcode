/*
 * @lc app=leetcode.cn id=1781 lang=cpp
 *
 * [1781] 所有子字符串美丽值之和
 *
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/description/
 *
 * algorithms
 * Medium (54.34%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    18.1K
 * Total Submissions: 27.8K
 * Testcase Example:  '"aabcb"'
 *
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 
 * 
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 
 * 
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "aabcbaa"
 * 输出：17
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 只包含小写英文字母。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int beautySum(string s) {
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            vector<int> cnt(26);
            int maxFreq = 0;
            for (int j = i; j < s.size(); j++) {
                cnt[s[j] - 'a']++;
                maxFreq = max(maxFreq, cnt[s[j] - 'a']); 
                int minFreq = s.size();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
};

// @lc code=end

