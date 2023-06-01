/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode.cn/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (43.57%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    103.6K
 * Total Submissions: 238.3K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 
 * 任何误差小于 10^-5 的答案都将被视为正确答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length
 * 1 <= k <= n <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // 滑动窗口解法
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double ans = 0;
        double[] sum = new double[n];
        int i = 0;
        sum[0] = nums[0];
        for (i = 1; i < k; i++) {
            sum[i] += sum[i - 1] + nums[i];
        }
        ans = sum[k - 1];
        for (i = k; i < n; i++) {
            sum[i] += nums[i] + sum[i - 1];
            sum[i] -= nums[i - k];
            ans = Math.max(ans, sum[i]);
        }
        ans /= k;
        return ans;
    }
}
// @lc code=end
