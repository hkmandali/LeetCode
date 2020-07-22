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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
        {
            return null;
        }
        else if(head.next == null)
        {
            return head;
        }
        else
        {
            ListNode evenhead = head.next;
            ListNode temp1 = head;
            ListNode temp2 = evenhead;
            ListNode prev1= temp1,prev2= temp2;
            while(temp1 != null && temp2 != null)
            {
                prev1 = temp1;
                temp1.next = temp2.next;
                temp1= temp1.next;
                if(temp1 != null)
                {
                    prev1 = temp1;
                    temp2.next = temp1.next;
                }
                else
                    temp2.next = null;
                prev2 = temp2;
                temp2 = temp2.next;
            }
            prev1.next = evenhead;
            prev2.next = null;
            
            return head;
        }
        
    }
}