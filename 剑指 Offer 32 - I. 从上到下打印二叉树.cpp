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
    vector<int> levelOrder(TreeNode* root) {
        vector<int> ans;
        if(root==nullptr) return ans;
        queue<TreeNode*> que;

        que.push(root);
        while(!que.empty())
        {
            TreeNode * temp = que.front();
            ans.push_back(temp->val);
            if(temp->left!=nullptr)
                que.push(temp->left);
            if(temp->right!=nullptr)
                que.push(temp->right);
            que.pop();
        }
        return ans;
    }
    
};