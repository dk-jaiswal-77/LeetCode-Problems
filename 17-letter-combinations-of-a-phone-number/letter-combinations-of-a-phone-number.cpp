class Solution {
public:
    void combinations(vector<string>& numToLetters, vector<string>& res, string& str, int idx, string currStr) {
        // Base case: if we've processed all digits and have a non-empty combination, add it to results
        if (idx == size(str) && currStr.size() > 0) {
            res.push_back(currStr);
            return;
        }
        
        // Get the current digit and map it to the corresponding letters
        char ch = str[idx];
        string letters = numToLetters[(ch - '0') - 2]; // Mapping digit to letters
        
        // Loop through all letters corresponding to the current digit and recurse
        for (int i = 0; i < letters.size(); i++) {
            combinations(numToLetters, res, str, idx + 1, currStr + letters[i]);
        }
    }
    
    vector<string> letterCombinations(string digits) {
        // If the input string is empty, return an empty result
        if (digits.empty()) return {};
        
        // Vector containing mappings from digits to letters
        vector<string> numToLetters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> res;
        
        // Start the recursive combination generation process
        combinations(numToLetters, res, digits, 0, "");
        
        // Return the result containing all combinations
        return res;
    }
};
