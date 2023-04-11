/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 先判断t1、t2是否完全相等
class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return false;
        // isIdentical函数使用dfs递归判断两个树的所有节点是否相等
        if (isIdentical(t1, t2)) {
            return true;
        }
        // 若不相等时，递归使用checkSubTree函数，dfs调用t1的左子树和右子树
        // 查看是否有节点与t2的根节点值相等
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }
}
