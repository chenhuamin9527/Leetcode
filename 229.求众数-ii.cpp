/*
 * @lc app=leetcode.cn id=229 lang=cpp
 *
 * [229] 求众数 II
 *
 * https://leetcode-cn.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (53.37%)
 * Likes:    529
 * Dislikes: 0
 * Total Accepted:    70.2K
 * Total Submissions: 131.5K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[3,2,3]
 * 输出：[3]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1]
 * 输出：[1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * 
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * 
 */

// @lc code=start
class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        unordered_map<int, int> map1;
        vector<int> ans;
        int n = nums.size();
        int zhong = n/3;
        for(int i = 0; i < n; i++)
        {
            map1[nums[i]]++;
        }
        for(auto & v : map1)
        {
            if(v.second > zhong)
            {
                ans.push_back(v.first);
            }
        }
        return ans;
        
    }

};
// @lc code=end

