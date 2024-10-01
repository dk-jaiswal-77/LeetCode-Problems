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
    ListNode *detectCycle(ListNode *head) {
        ListNode *slow, *fast;
        if (head == NULL) return head;
        slow = head;
        fast = head -> next;
        bool hasCycle = false;
        while (fast != NULL && fast -> next != NULL) {
            if (fast == slow) {
                hasCycle = true;
                break;
            }
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        if (!hasCycle) return NULL;
        slow = head;
        fast = fast -> next;
        while(slow != fast) {
            slow = slow -> next;
            fast = fast -> next;
        }
        return slow;
    }
};