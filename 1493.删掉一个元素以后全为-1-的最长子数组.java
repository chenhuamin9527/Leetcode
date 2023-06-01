/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 *
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 *
 * algorithms
 * Medium (59.14%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    17.9K
 * Total Submissions: 30.1K
 * Testcase Example:  '[1,1,0,1]'
 *
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 
 * 如果不存在这样的子数组，请返回 0 。
 * 
 * 
 * 
 * 提示 1：
 * 
 * 
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 与Leetcode1456题目思路基本一样，只去除一个元素
    // 将结果的子序列长度-1即可
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int ans = 0;
        int lsum = 0, rsum = 0;
        if (n < 2)
            return 0;
        for (right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            while (rsum - lsum > 1) {
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
// @lc code=end
