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
    ListNode* oddEvenList(ListNode* head) {
        int idx = 1;
        ListNode* temp = head;
        ListNode *odd = NULL, *even = NULL;
        ListNode *evenTail = NULL, *oddTail = NULL;
        while(temp != NULL) {
            if (idx % 2 == 0) {
                if (evenTail == NULL) {
                    evenTail = temp;
                    even = temp;
                } else {
                    evenTail -> next = temp;
                    evenTail = temp;
                }
            } else {
                if (oddTail == NULL) {
                    oddTail = temp;
                    odd = temp;
                } else {
                    oddTail -> next = temp;
                    oddTail = temp;
                }
            }
            temp = temp -> next;
            idx++;
        }
        if (oddTail != NULL) {
            oddTail -> next = even;
        }
        if (evenTail != NULL) {
            evenTail -> next = NULL;
        }
        return odd;
    }
};