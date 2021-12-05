class Solution {
public:
    ListNode* deleteNode(ListNode* head, int val) {
        if(head == nullptr) return head;
        ListNode *first = head;
        ListNode *second = head->next;
        if(first->val == val)
        {
            return first->next;
        }
        while(second!=nullptr)
        {
            if(second->val == val)
            {
                second = second->next;
                first->next = second;
            }
            first = first->next;
            second = second->next;
        }
        return head;
    }
};