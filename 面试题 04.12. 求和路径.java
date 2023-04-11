/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 关键思路：使用helper函数进行dfs递归，将行径路径的和与目标值作为参数进行传递
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int rootPathSum = helper(root, sum, 0);
        int leftPathSum = pathSum(root.left, sum);
        int rightPathSum = pathSum(root.right, sum);
        return rootPathSum + leftPathSum + rightPathSum;
    }

    private int helper(TreeNode root, int target, int curSum) {
        if (root == null)
            return 0;
        curSum += root.val;
        int totalPaths = 0;
        if (curSum == target)
            totalPaths++;
        totalPaths += helper(root.left, target, curSum);
        totalPaths += helper(root.right, target, curSum);
        return totalPaths;
    }

}