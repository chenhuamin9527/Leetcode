/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 1. 递归实现，每次递归到下一层记录lower（最小的值）和upper（最大的值）
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(root.right, val, upper)) {
            return false;
        }
        if (!helper(root.left, lower, val)) {
            return false;
        }
        return true;
    }
}

// 2. 使用中序遍历，因为二叉搜索树的中序遍历为有序数列。
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = Double.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}