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
    void deleteNode(ListNode* node) {
        ListNode* mover = node;
        while (mover) {
            mover -> val = mover -> next -> val;
            if (mover -> next -> next == NULL) {
                mover -> next = NULL;
                return;
            }
            mover = mover -> next;
        }
    }
};