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
    bool isPalindrome(ListNode* head) {
        string forward = "";
        // string backward = "";
        // long long place = 1;
        ListNode* temp = head;
        char val;
        while(temp != NULL) {
            val = (char)(temp -> val);
            forward.push_back(val);
            // backward.insert(0, 1, val);
            // place *= 10;
            temp = temp -> next;
        }

        int left = 0;
        int right = forward.size() - 1;
        while (left < right) {
            if (forward[left] != forward[right]) return false;
            left++;
            right--;
        }
        return true;
    }
};