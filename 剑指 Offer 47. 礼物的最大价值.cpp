// 原地修改
class Solution {
public:
    int maxValue(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if(m == 0||n==0) return 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j == 0) 
                {
                    continue;
                }
                if(i == 0 && j!=0) 
                {
                    grid[i][j] = grid[i][j]+grid[i][j-1];
                    continue;
                }

                if(j == 0 && i!=0) 
                {
                    grid[i][j] = grid[i][j]+grid[i-1][j];
                    continue;
                }
                grid[i][j] = max(grid[i][j-1]+grid[i][j],grid[i-1][j]+grid[i][j]);
            }
        }
        return grid[m-1][n-1];
    }
};




