/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.63%)
 * Likes:    6191
 * Dislikes: 0
 * Total Accepted:    871.3K
 * Total Submissions: 2.1M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int nums3[] = new int[m+n];
        if (m == 0)
        {
            if (n % 2 == 0)
            {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }
            else 
            {
                return nums2[n / 2];
            }
        }
        if (n == 0) 
        {
            if (m % 2 == 0) 
            {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            }
            else 
            {
                return nums1[m / 2];
            }
        }
        int p1 = 0, p2 = 0;
        int count = 0;
        double mid = 0;
        while(count != (m+n))
        {
            if(p1 == m)
            {
                while(p2 != n)
                {
                    nums3[count++] = nums2[p2++];
                }
                break;
            }
            if(p2 == n)
            {
                while(p1 != m)
                {
                    nums3[count++] = nums1[p1++];
                }
                break;
            }
            if(nums1[p1] < nums2[p2])
            {
                nums3[count++] = nums1[p1++];
            }
            else
            {
                nums3[count++] = nums2[p2++];
            }
        }
        if(count%2!=0)
        {
            mid = nums3[count/2];
        }
        else
        {
            mid = (nums3[count/2]+nums3[count/2-1])/2.0;
        }
        return mid;
    }
}
// @lc code=end

