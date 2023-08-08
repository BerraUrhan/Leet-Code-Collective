import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        /* Iterative Solution - 1 from Emirhan: */
        /* Using stack + reversing */
        /*
        Using Stack data structure, we will do traversing reversely.
        If you traverse a tree in Root->Right->Left order and reverse, you will
        end up with Post-Order traversal.
        */

        if  (root == null)
            return null;

        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        TreeNode top;
        while (!stack.isEmpty()){
            top = stack.pop();
            answer.add(top.val);

            if (top.left != null)
                stack.add(top.left);
            if (top.right != null)
                stack.add(top.right);
        }

        Collections.reverse(answer);
        return answer;
    }
}