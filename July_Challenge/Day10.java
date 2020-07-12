/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node getLastinRow(Node node)
    {
        if(null == node)
            return null;
        else
        {
            while(node.next != null)
            {
                node = node.next;
            }
        }
        return node;
    }
    public Node flattenSub(Node temp)
    {
        if(null == temp)
            return null;
        if(temp.next != null || temp.child !=null)        
        {
            if(null == temp.child)
            {
                Node next = temp.next;
                if(null == next)
                    return temp;
                temp.next = flattenSub(next);
                next.prev = temp;
            }
            else
            {
                if(temp.next != null)
                {                    
                    Node next = temp.next;
                    Node child = temp.child;
                    temp.child = null;
                    temp.next = flattenSub(child);
                    child.prev = temp;
                    Node last = getLastinRow(child);
                    last.next  = flattenSub(next);
                    //last.next = next;                    
                    next.prev = last;
                }
                else 
                {
                    Node child = temp.child;
                    temp.child = null;
                    temp.next = flattenSub(child);
                    child.prev = temp;
                }
            }
        }
        temp.child = null;
        return temp;
    }
    public Node flatten(Node head) {
        if(null == head)
            return null;
        Node temp = head;
        temp = flattenSub(temp);
        
        return head;
    }
}