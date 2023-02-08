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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head==NULL || head->next==NULL && n==1){
            return NULL;
        }
        int count=0;
        ListNode* temp=head;
        ListNode* curr=head;
        while(temp!=NULL && temp->next!=NULL){
            temp=temp->next;
            count++;
        }
       int k=count-n;
       if(k<0){
           head=head->next;
           return head;
       }
       for(int i=0; i<k; i++){
           curr=curr->next;
       }
       curr->next=curr->next->next;
       return head;
    }
};