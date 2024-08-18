class Solution {
public:
    void combinations(vector<vector<int>> &res, vector<int> &temp, vector<int> &candidates, int idx, int currSum, int &target) {
        if (idx == candidates.size()) {
            if (currSum == target) {
                res.push_back(temp);
            }
            return;
        }
        // two options:
        // to include curr ele or not
        // 1. not including curr ele
        combinations(res, temp, candidates, idx + 1, currSum, target);
        // 2. including single or multiple instances of curr ele
        // until currSum <= target
        currSum += candidates[idx];
        while (currSum <= target) {
            temp.push_back(candidates[idx]);
            combinations(res, temp, candidates, idx + 1, currSum, target);
            currSum += candidates[idx];
        }
        while(!temp.empty() && temp.back() == candidates[idx]) {
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> temp;
        combinations(res, temp, candidates, 0, 0, target);
        return res;
    }
};