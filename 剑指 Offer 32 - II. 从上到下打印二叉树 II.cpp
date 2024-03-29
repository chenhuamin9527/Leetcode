/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> que;
        vector<vector<int>> ans;
        if(root == nullptr) return ans;
        que.push(root);
        while(!que.empty())
        {
            int cur_size = que.size();
            ans.push_back(vector<int> ());
            for(int i = 1; i <= cur_size; i++)
            {
                TreeNode* temp = que.front();
                que.pop();
                ans.back().push_back(temp->val);
                if(temp->left) que.push(temp->left);
                if(temp->right) que.push(temp->right);
            }
        }
        return ans;
    }
};