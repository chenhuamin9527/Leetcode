/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> BSTSequences(TreeNode root) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 如果 root==null 返回 [[]]
        if (root == null) {
            ans.add(path);
            return ans;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 开始进行回溯
        bfs(queue, path);
        return ans;
    }

    /**
     * 回溯法+广度优先遍历.
     */
    private void bfs(List<TreeNode> queue, List<Integer> path) {
        // queue 为空说明遍历完了，可以返回了
        if (queue.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 将 queue 拷贝一份，用于稍后回溯
        List<TreeNode> copy = new ArrayList<>(queue);
        // 对 queue 进行循环，每循环考虑 “是否 「将当前 cur 节点从 queue 中取出并将其左右子
        // 节点加入 queue ，然后将 cur.val 加入到 path 末尾」 ” 的情况进行回溯
        for (int i = 0; i < queue.size(); i++) {
            TreeNode cur = queue.get(i);
            path.add(cur.val);
            queue.remove(i);
            // 将左右子节点加入队列
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            bfs(queue, path);
            // 恢复 path 和 queue ，进行回溯
            path.remove(path.size() - 1);
            queue = new ArrayList<>(copy);
        }
    }
}
