/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 1. 自定向下检查是否平衡
// 检查左右字数高度差是否小于等于1
// 检查左右子树是否平衡
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 递归，每次深度+1，选出左右子树中最大的深度
    public int height(TreeNode root) {
        if (root == null)
            return 1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
// 2. 自底向上的递归
