/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (67.74%)
 * Likes:    1330
 * Dislikes: 0
 * Total Accepted:    408.7K
 * Total Submissions: 603.3K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * 示例 2:
 * 
 * 
 * 输入: strs = [""]
 * 输出: [[""]]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
public:
     vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res ;
        map<string, vector<string>> map ;

        // 统计string的各字母频次,以频次为key直接加入队列
        for (auto s : strs) {
            string sts = string(26, '0') ;
            for (auto c : s)  ++ sts[c-'a'] ;
            map[sts].emplace_back (s) ;
        }
        for (auto e : map)  res.emplace_back(e.second) ;

        return res ;
    }
};
// @lc code=end

