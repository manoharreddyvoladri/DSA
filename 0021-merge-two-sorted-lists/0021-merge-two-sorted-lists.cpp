/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list2 == nullptr)
            return list1; 
        if(list1 == nullptr)
            return list2; 
        
        ListNode* m = list1;

        ListNode* c = list1;
        ListNode* p = nullptr;
        ListNode* c1 = list2;

        while(c1 != nullptr){
            ListNode* n = c1->next;
            while(c != nullptr && c1->val > c->val){
                 p = c;
                 c = c->next;
            }
            if(p == nullptr){
                m = c1;
                p = c1;
                c1->next = c;
            }
            else
            {
                p->next = c1;
                c1->next = c;
                p = c1;
            }
            c1 = n; 
        }
        return m;
    }
};