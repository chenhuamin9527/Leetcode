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
        if(root==nullptr) return vector<int>();
        queue<TreeNode*> que1;
        que1.push(root);
        while(!que1.empty())
        {
            TreeNode* temp = que1.front();
            if(temp->left) que1.push(temp->left);
            if(temp->right) que1.push(temp->right);
            ans.push_back(temp->val);
            que1.pop();
        }
        return ans;
    }
};