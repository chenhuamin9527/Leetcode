// 扫描算法，在board[i][j] = 'X'时开始扫描垂直和水平方向将所有'X'替换为'.'
class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        int row = board.size();
        int col = board[0].size();
        int ans = 0;
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                if (board[i][j] == 'X')
                {
                    board[i][j] = '.';
                    for (int k = j + 1; k < col && board[i][k] == 'X'; ++k)
                    {
                        board[i][k] = '.';
                    }                    
                    for (int k = i + 1; k < row && board[k][j] == 'X'; ++k)
                    {
                        board[k][j] = '.';
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
};

// 深度优先算法
class Solution {
public:
    int m, n;
    int countBattleships(vector<vector<char>>& board) {
        m = board.size();
        n = board[0].size();

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.' || board[i][j] == 'Y') continue;
                dfs(board, i, j);
                cnt++;
            }
        }
        return cnt;
    }

    int dx[2] = {0, 1};
    int dy[2] = {1, 0};

    void dfs(vector<vector<char>>& b, int i, int j) {
        b[i][j] = 'Y';
        for (int d = 0; d < 2; d++) {
            int ii = i + dx[d];
            int jj = j + dy[d];
            
            if (ii < 0 || jj < 0 || ii >= m || jj >= n) continue;
            if (b[ii][jj] == 'Y' || b[ii][jj] == '.') continue;
            dfs(b, ii, jj);
        }
    }


};


