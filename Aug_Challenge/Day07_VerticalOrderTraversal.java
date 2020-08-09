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
    /*
    void populate(TreeNode root,TreeMap<Integer,List<Integer>> map,int position)
    {
        if(null == root)
            return;
        
        if(map.get(position) == null)
        {
            List<Integer> arr = new ArrayList();
            arr.add(root.val);
            map.put(position,arr);
        }
        else
        {
            List<Integer> arr = map.get(position);
            arr.add(root.val);
            map.put(position,arr);
        }
        populate(root.left,map,position-1);
        populate(root.right,map,position+1);
        return;
    }
    
    void populatewithoutrecur(TreeNode root,TreeMap<Integer,PriorityQueue<Integer>> map)
    {
        if(null == root)
            return;
        Queue<Pair<TreeNode,Integer>> que = new LinkedList();
        que.add(new Pair(root,0));
        
        while(!que.isEmpty())
        {
           Pair<TreeNode,Integer> current = que.poll();
           TreeNode node = current.getKey();
            int position = current.getValue();
           if(map.get(position) == null)
            {
                PriorityQueue<Integer> arr = new PriorityQueue();
                arr.add(node.val);
                map.put(position,arr);
            }
            else
            {
                PriorityQueue<Integer> arr = map.get(position);
                arr.add(node.val);
                map.put(position,arr);
            }
            if(node.left != null)
            {
                que.add(new Pair(node.left,position-1));
            }
            if(node.right != null)
            {
                que.add(new Pair(node.right,position+1));
            }          
            
        }
        
        
        
        
        return;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret= new ArrayList();
        TreeMap<Integer,PriorityQueue<Integer>> map = new TreeMap();
        //populate(root,map,0);
        populatewithoutrecur(root,map);
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet())
        {
            //List<Integer> val = entry.getValue();
            List<Integer> val = new ArrayList();
            PriorityQueue<Integer> pq = entry.getValue();
            while(!pq.isEmpty())
            {
                val.add(pq.poll());
            }
            ret.add(val);
        }
        return ret;
    }
    */
    private class Pair {
        TreeNode node;
        int x, y;

        Pair(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    private class ByY implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.y == o2.y)
                return o1.node.val - o2.node.val;

            if (o1.y < o2.y) return 1;
            return -1;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            TreeNode node = pair.node;
            int px = pair.x, py = pair.y;
            min = Math.min(px, min);
            max = Math.max(px, max);

            if (!map.containsKey(px)) map.put(px, new PriorityQueue<>(new ByY()));
            map.get(px).add(pair);

            if (node.left != null) {
                queue.add(new Pair(node.left, px - 1, py - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, px + 1, py - 1));
            }
        }

        for (int x = min; x <= max; x++) {
            PriorityQueue<Pair> pq = map.get(x);
            List<Integer> item = new ArrayList<>();
            while (!pq.isEmpty()) {
                item.add(pq.poll().node.val);
            }
            results.add(item);
        }
        return results;
    }
}