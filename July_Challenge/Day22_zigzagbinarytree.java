/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(null == root)
        {
            return ret;
        }
        boolean order = true; // lefttoright
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        st.push(root);
        List<Integer> obj = new ArrayList<>();
        while(!st.isEmpty())
        {
            TreeNode popped = st.pop();
            obj.add(popped.val);
            if(order)
            {
                if(popped.left != null)
                {
                    nextLevel.push(popped.left);
                }
                if(popped.right != null)
                {
                    nextLevel.push(popped.right);
                }
            }
            else if(!order)
            {
                if(popped.right != null)
                {
                    nextLevel.push(popped.right);
                }
                if(popped.left != null)
                {
                    nextLevel.push(popped.left);
                }
            }
            
            if(st.isEmpty())
            {
                order = !order;
                ret.add(obj);
                obj = new ArrayList<>();
                Stack<TreeNode> temp = st;
                st = nextLevel;
                nextLevel = temp;
            }
            
            
            
        }
        
        return ret;
    }
}