/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* first = nullptr;
        if(head==nullptr||head->next==nullptr)
        {
            return head;
        }
        ListNode* second = head;
        
        while(second!=nullptr)
        {
            ListNode* temp = second->next;
            second->next = first;
            first = second;
            second = temp;
        }
        return first;
    }
};