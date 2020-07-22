/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(null == head )
        {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null && temp.val == val) // if the head itseld is the key to be deleted
        {
            head = temp.next;
            temp = head;
        }
        
        if(null == head)
            return head; // if all the nodes are deleted
        
        while(temp!= null) // now we have a head , we need to propagate till we find the value which is same as to be deleted
        {
            while(temp != null && val != temp.val)// doesnt match
            {
                
                prev = temp;
                temp = temp.next;
            }
            
            // we break once we reach the value or null
            
            if( null == temp) // null
                return head;
            
            // temp value is val
            
            while(temp!=null && temp.val == val)
            {
                prev.next = temp.next;
                temp = temp.next;
            }
            
            //prev.next = temp.next;
            //temp = temp.next;
            
        }
        return head;
    }
}