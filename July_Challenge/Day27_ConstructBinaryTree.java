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
    int lastindex = 0;
    TreeNode ConstructTree(int[] inorder,int[] postorder,int start,int end,HashMap<Integer,Integer> map)
    {
        if(start > end)
            return null;
        int value = postorder[lastindex];
        lastindex--;
        TreeNode root = new TreeNode(value);
        if(start == end)
            return root;
        int index = map.get(value);
        root.right = ConstructTree(inorder,postorder,index+1,end,map);
        root.left = ConstructTree(inorder,postorder,start,index-1,map);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null == inorder || null == postorder || 0 == inorder.length || 0 == postorder.length)   
            return null;
        int len = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>(); // value vs index mapping in inorder
        for(int i=0;i<len;++i)
        {
            map.put(inorder[i],i);
        }
        lastindex = len-1;
        return ConstructTree(inorder,postorder,0,len-1,map);
    }
}