/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 两次遍历，首先算出链表长度
// class Solution {
// public:
//     ListNode* getKthFromEnd(ListNode* head, int k) {
//         if(k == 0) return head;
//         int n = 0;
//         ListNode * p = head;
//         while(p != nullptr)
//         {
//             p = p->next;
//             n++;
//         }
//         int num = n - k;
//         while(num--)
//         {
//             head = head->next;
//         }
//         return head;
//     }
// };

// 第二种方法，双指针，一个指针先运动k步
class Solution {
public:
    ListNode* getKthFromEnd(ListNode* head, int k) {
        if(k == 0) return head;
        ListNode * first = head;
        ListNode * second = head;
        for(int i = 0; i < k; i++)
        {
            first = first->next;    //此时两个指针之间相差k
        }
        while(first!=nullptr)
        {
            first = first->next;
            second = second->next;
        }
        return second;
    }
};