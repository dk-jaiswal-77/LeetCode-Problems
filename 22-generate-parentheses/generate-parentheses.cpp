class Solution {
public:
    void generateParenthesis(vector<string>& res, string& str, int& n, int openCount, int closeCount) {
        if (closeCount == n) {
            res.push_back(str);
            return;
        }
        // option 1: consider '('
        if (openCount < n) {
            str.push_back('(');
            generateParenthesis(res, str, n, openCount + 1, closeCount);
            str.pop_back();
        }
        // option 2: consider ')'
        if (closeCount < openCount) {
            str.push_back(')');
            generateParenthesis(res, str, n, openCount, closeCount + 1);
            str.pop_back();
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string str = "";
        generateParenthesis(res, str, n, 0, 0);
        return res;    
    }
};