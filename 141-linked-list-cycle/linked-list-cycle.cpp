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
    bool hasCycle(ListNode *head) {
        ListNode *slow, *fast;
        slow = head;
        if (head == NULL) return false;
        fast = head -> next;
        while (fast != NULL && (fast -> next) != NULL) {
            if (fast == slow) return true;
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        return false;
    }
};