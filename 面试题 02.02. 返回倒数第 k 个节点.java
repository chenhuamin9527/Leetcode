/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode fastP = head;
        for (int i = 0; i < k; i++) {
            fastP = fastP.next;
        }
        ListNode slowP = head;
        while (fastP != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        return slowP.val;
    }
}