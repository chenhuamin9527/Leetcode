// 1. 逆向dfs解决
class Solution {
    private boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        this.visited = new boolean[graph.length];
        return dfs(graph, start, target);
    }

    boolean dfs(int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (graph[i][0] == start && graph[i][1] == target)
                    return true;
                visited[i] = true;
                // 关键代码， 逆向搜索，先找到终点，再继续递归找到起点
                if (graph[i][1] == target && dfs(graph, start, graph[i][0]))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}

// 2. 将数据转换为邻接矩阵，用bfs解决
class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 将矩阵转为邻接表
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null)
                adj[from] = new ArrayList<>();
            adj[from].add(to);
        }
        // 建一个函数进行广度遍历
        return hasPath(n, adj, start, target);
    }

    private boolean hasPath(int n, List<Integer>[] arrayList, int start, int target) {

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int temp = queue.poll();
            if (arrayList[temp] == null) {
                continue;
            }

            for (Integer num : arrayList[temp]) {

                if (num == target) {
                    return true;
                }

                if (visited[num]) {
                    continue;
                } else {

                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }

        return false;
    }

}