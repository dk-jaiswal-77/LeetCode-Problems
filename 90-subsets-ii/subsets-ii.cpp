class Solution {
public:
    bool contains(vector<vector<int>>& matrix, vector<int>& arr) {
        for(auto& currArr: matrix) {
            if (currArr == arr) return true;
        }
        return false;
    }

    void subsets(vector<int>& nums, int idx, vector<int>& temp, vector<vector<int>>& res) {
        if (idx == nums.size()) {
            // now check if temp arr is present in res
            // push it to res only if it is not present in res
            if (contains(res, temp)) return;
            res.push_back(temp);
            return;
        };
        // do not include current ele
        subsets(nums, idx + 1, temp, res);
        temp.push_back(nums[idx]);
        // include current ele
        subsets(nums, idx + 1, temp, res);
        // reset `temp` arr to its original state
        temp.pop_back();
        return;
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> temp;
        vector<vector<int>> res;
        subsets(nums, 0, temp, res);
        return res;
    }
};