/*
 * @lc app=leetcode.cn id=1605 lang=java
 *
 * [1605] 给定行和列的和求可行矩阵
 *
 * https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/description/
 *
 * algorithms
 * Medium (76.26%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    20K
 * Total Submissions: 24.8K
 * Testcase Example:  '[3,8]\n[4,7]'
 *
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j
 * 列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * 
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum
 * 的要求。
 * 
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 * ⁠     [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 * ⁠                 [3,5]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：rowSum = [5,7,10], colSum = [8,6,8]
 * 输出：[[0,5,0],
 * ⁠     [6,1,0],
 * ⁠     [2,0,8]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：rowSum = [14,9], colSum = [6,9,8]
 * 输出：[[0,9,5],
 * ⁠     [6,0,3]]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：rowSum = [1,0], colSum = [1]
 * 输出：[[1],
 * ⁠     [0]]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：rowSum = [0], colSum = [0]
 * 输出：[[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 10^8
 * sum(rowSum) == sum(colSum)
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length; // 获取总行数
        int col = colSum.length; // 获取总列数
        int[][] matrix = new int[row][col]; // 构造矩阵，初始化所有元素都为0
        int r = 0; // 当前行 初始首行
        int c = 0; // 当前列 初始首列
        while (r < row && c < col) { // 仅当行列都在范围内进行操作
            matrix[r][c] = Math.min(rowSum[r], colSum[c]); // 构成matrix[r][c]
            rowSum[r] -= matrix[r][c]; // 所在行元素总和减少matrix[r][c]
            colSum[c] -= matrix[r][c]; // 所在列元素总和减少matrix[r][c]
            if (rowSum[r] == 0) {
                // 所在行元素总和已为0，该行剩下元素都为0，处理下一行
                r++;
            } else {
                // 所在列元素总和已为0，该列剩下元素都为0，处理下一列
                c++;
            }
        }
        return matrix;
    }
}

// @lc code=end
