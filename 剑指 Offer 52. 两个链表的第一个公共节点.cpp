// 哈希表存储结点
// class Solution {
// public:
//     ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
//         unordered_set<ListNode* > visited;
//         ListNode* temp1 = headA;
//         while(temp1!=nullptr)
//         {
//             visited.insert(temp1);
//             temp1 = temp1->next;
//         }
//         temp1 = headB;
//         while(temp1!=nullptr)
//         {
//             if(visited.count(temp1))
//             {
//                 return temp1;
//             }
//             temp1 = temp1->next;
//         }
//         return nullptr;
//     }
// };


class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == nullptr || headB == nullptr) {
            return nullptr;
        }
        ListNode *pA = headA, *pB = headB;
        while (pA != pB) {
            pA = pA == nullptr ? headB : pA->next;
            pB = pB == nullptr ? headA : pB->next;
        }
        return pA;
    }
};

