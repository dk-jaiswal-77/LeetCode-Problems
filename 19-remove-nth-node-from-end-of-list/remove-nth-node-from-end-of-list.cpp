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
        int count = 0;
        // ListNode *temp = head;
        ListNode *left = head, *right = head;
        while (count < n) {
            right = right -> next;
            count++;
        }
        if (right == NULL) {
            // remove head node
            return (head -> next);
        }
        while (right -> next != NULL) {
            left = left -> next;
            right = right -> next;
        }
        left -> next = left -> next -> next;
        return head;
    }
};