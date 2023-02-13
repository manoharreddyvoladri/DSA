/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(root==nullptr)
            return root;
        root->next=NULL;
        rec(root);
        return root;
    }
    void rec(Node* n){
        if(n->left==nullptr)
            return;
        n->left->next = n->right;
        if(n->next==NULL)
            n->right->next=NULL;
        else
            n->right->next = n->next->left;
        rec(n->left);
        rec(n->right);
    }
};