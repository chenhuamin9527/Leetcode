class Solution {
public:  
    bool bitcal(int a, int b, int c)
    {
        int sum = 0;
        while(a)
        {
            sum += a%10;
            a/=10;
        }
        while(b)
        {
            sum += b%10;
            b/=10;
        }
        if(sum > c) return false;
        return true;
    }
    int movingCount(int m, int n, int k) {
        vector<vector<bool>> visited(m, vector<bool>(n, 0));
        return dfs(m,n,0,0,k,visited);
    }
    int dfs(int m, int n, int i, int j, int k,vector<vector<bool>> &visited)
    {
        if(i < 0 || j < 0 || i >= m || j >= n || !bitcal(i,j,k) || visited[i][j]) return 0;
        visited[i][j] = true;
        
        return 1+dfs(m,n,i+1,j,k,visited)+dfs(m,n,i,j+1,k,visited)+
        dfs(m,n,i-1,j,k,visited)+dfs(m,n,i,j-1,k,visited);
    }
};