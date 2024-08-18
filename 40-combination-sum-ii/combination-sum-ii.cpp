class Solution {
public:
    void combinations(vector<vector<int>> &res, vector<int> &temp, vector<pair<int, int>> &candidates, int idx, int currSum, int target) {
        if (currSum == target) {
            res.push_back(temp);
            return;
        }
        if (idx == candidates.size() || currSum > target) return;

        // Option 1: Do not include the current candidate
        combinations(res, temp, candidates, idx + 1, currSum, target);
        
        // Option 2: Include the current candidate (up to its frequency limit)
        int num = candidates[idx].first;
        int freq = candidates[idx].second;
        for (int i = 0; i < freq; ++i) {
            currSum += num;
            if (currSum > target) break;
            temp.push_back(num);
            combinations(res, temp, candidates, idx + 1, currSum, target);
        }
        
        // Backtrack
        for (int i = 0; i < freq; ++i) {
            if (!temp.empty() && temp.back() == num) {
                temp.pop_back();
            }
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> temp;
        sort(candidates.begin(), candidates.end());

        // Build frequency vector
        vector<pair<int, int>> freqVec;
        for (int ele : candidates) {
            if (freqVec.empty() || freqVec.back().first != ele) {
                freqVec.emplace_back(ele, 1);
            } else {
                freqVec.back().second++;
            }
        }

        // Start combinations
        combinations(res, temp, freqVec, 0, 0, target);
        return res;
    }
};