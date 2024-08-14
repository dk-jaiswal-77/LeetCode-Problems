class Solution {
public:
    bool isPalindrome(string& str) {
        int left = 0;
        int right = str.size() - 1;
        while (left < right) {
            if (str[left] != str[right]) return false;
            left++;
            right--;
        }
        return true;
    }
    void partitions(vector<vector<string>>& res, vector<string>& vStr, int idx, string& str) {
        if (idx == str.size()) {
            res.push_back(vStr);
            return;
        }
        string currStr;
        for (int i = idx; i < str.size(); i++) {
            currStr += str[i];
            if ((str[i] == str[idx]) && (isPalindrome(currStr))) {
                vStr.push_back(currStr);
                partitions(res, vStr, i + 1, str);
                vStr.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> vStr;
        partitions(res, vStr, 0, s);
        return res;
    }
};