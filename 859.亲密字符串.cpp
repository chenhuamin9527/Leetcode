/*
 * @lc app=leetcode.cn id=859 lang=cpp
 *
 * [859] 亲密字符串
 */

// @lc code=start
#include <iostream>
#include <vector>
class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if(s.size()!= goal.size()) return false;
        int first = -1;
        int second = -1;
        if (s == goal) {
            vector<int> count(26);
            for (int i = 0; i < s.size(); i++) {
                count[s[i] - 'a']++;
                if (count[s[i] - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        else 
        {
            for(int i = 0; i < s.size(); i++)
            {
                if(s[i]!=goal[i])
                {
                    if(first == -1) first = i;
                    else if (second == -1) second = i;
                    else return false;
                }
            }
            return (second != -1 && s[first] == goal[second] && s[second] == goal[first]);
        }

    }
};
// @lc code=end
