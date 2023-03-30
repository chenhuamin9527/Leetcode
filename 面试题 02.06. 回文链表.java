import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        int first = 0, second = 0;
        while (head != null) {
            vals.add(head.val);
            second++;
            head = head.next;
        }
        second--;
        while (first <= second) {
            if (!vals.get(first).equals(vals.get(second)))
                return false;
            first++;
            second--;
        }
        return true;
    }
}
