import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Day05_MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || 0 == lists.length)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a,ListNode b)
            {
                if(a.val < b.val)
                {
                    return -1;
                }
                else if(a.val > b.val)
                    return 1;
                else
                    return 0;
            }
        });
        int len = lists.length;
        for(int i=0;i<len;++i)
        {
            System.out.println(lists[i].val);
            if(null != lists[i])
                pq.add(lists[i]);
        }
        if(pq.isEmpty())
            return null;
        ListNode curr = pq.poll();
        ListNode head = new ListNode(curr.val);
        ListNode res = head;
        if(curr.next != null)
        {
            pq.add(curr.next);
        }
        while(!pq.isEmpty())
        {
            curr= pq.poll();
            System.out.println("line 45 "+curr.val);
            res.next = new ListNode(curr.val);
            if(curr.next != null)
            {
                pq.add(curr.next);
            }
            res = res.next;
        }
        res.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b= new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c= new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = a;
        lists[1] = b;
        lists[2] = c;
        //ListNode res = new Day05_MergeKSortedLinkedLists().mergeKLists([[]]);
        ListNode res = new Day05_MergeKSortedLinkedLists().mergeKLists(lists);
        while(res != null)
        {
            System.out.println(res.val + "->");
            res = res.next;
        }
    }
}
