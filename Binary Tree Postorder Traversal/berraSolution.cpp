/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void recursion(TreeNode* root, vector<int>&vec) 
    {
        // base case, if root is null return
        if (root == NULL)
        {
            return;
        }
        // recursive case
        
        if (root->left != NULL)
        {
            recursion(root->left, vec);
        }
        if (root->right != NULL)
        {
            recursion(root->right, vec);
        }
        // push the value to the vector
        vec.push_back(root->val);
    }
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> vec;
        recursion(root,vec);
        return vec;
    }
};