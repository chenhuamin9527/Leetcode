/*
 * @lc app=leetcode.cn id=1034 lang=cpp
 *
 * [1034] 边框着色
 *
 * https://leetcode-cn.com/problems/coloring-a-border/description/
 *
 * algorithms
 * Medium (43.66%)
 * Likes:    107
 * Dislikes: 0
 * Total Accepted:    19.1K
 * Total Submissions: 35.2K
 * Testcase Example:  '[[1,1],[1,2]]\n0\n0\n3'
 *
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color
 * 。网格中的每个值表示该位置处的网格块的颜色。
 * 
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 * 
 * 
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * 
 * 
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * 
 * 
 * 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 
 * 
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 
 * 示例 3：
 * 
 * 
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 * 
 * 
 * 
 * 
 */

// @lc code=start

class Solution {
public:
    vector<vector<int>> vis;
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};        
    int m;
    int n;

    void dfs(vector<vector<int>>& g, int si, int sj, int target) {
        if (vis[si][sj]) return;
        vis[si][sj] = 1;
        if (g[si][sj] != target) return;

        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int i = si + dx[d];
            int j = sj + dy[d];
            if (i < m && i >= 0 && j < n && j >= 0) {
                if (g[i][j] == target || g[i][j] == 0) {
                    cnt++;
                    dfs(g, i, j, target);
                }
            }
        }
        if (cnt != 4) g[si][sj] = 0;

    }

    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        m = grid.size();
        n = grid[0].size();
        vis = vector<vector<int>>(m, vector<int>(n, 0));

        int target = grid[row][col];

        dfs(grid, row, col, target);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) grid[i][j] = color;
            }
        }

        return grid;
    }
};



// @lc code=end

