/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode node, int target) {
        if (node == null)
            return;
        path.offerLast(node.val);

        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        path.pollLast();
    }
}