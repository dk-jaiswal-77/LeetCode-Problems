class Solution {
    public:
    void subsets(vector<int>& nums, int idx, vector<int>& temp, vector<vector<int>>& res) {
        if (idx == nums.size()) {
            res.push_back(temp);
            return;
        };
        // not to include current ele
        subsets(nums, idx + 1, temp, res);
        temp.push_back(nums[idx]);
        subsets(nums, idx + 1, temp, res);
        temp.pop_back();
        return;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> temp;
        vector<vector<int>> res;
        subsets(nums, 0, temp, res);
        return res;
    }
};