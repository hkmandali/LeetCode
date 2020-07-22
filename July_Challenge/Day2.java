class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(null == root)
        {
            return ret;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            int size = que.size();
            List<Integer> inter= new ArrayList<>();
            for(int i=0;i<size;++i)
            {
                TreeNode top = que.poll();
                if(top.left != null)
                {
                    que.add(top.left);
                }
                if(top.right != null)
                {
                    que.add(top.right);
                }
                inter.add(top.val);
            }
            ret.add(0,inter);
        }
        return ret;
        
    }
}