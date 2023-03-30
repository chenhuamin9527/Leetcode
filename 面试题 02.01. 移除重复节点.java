/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode p = head;
        while (p.next != null) {
            ListNode cur = p.next;
            if (occurred.add(cur.val)) {
                p = p.next;
            } else {
                p.next = p.next.next;
            }
        }
        p.next = null;
        return head;
    }
}
