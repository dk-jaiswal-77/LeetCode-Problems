#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

class Solution {
public:
    bool isDivisionResultSumGreater(vector<int>& arr, int d, int threshold) {
        int len = arr.size();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += ceil(arr[i] / (float)d);
            if (sum > threshold) {
                return true;
            }
        }
        return false;
    }
    int finalSmallestDivisor(int sd, vector<int>& nums, int threshold) {
        int left = 1;
        int right = sd - 1;
        int mid;
        int res = sd;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isDivisionResultSumGreater(nums, mid, threshold)) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        sort(nums.begin(), nums.end());
        int len = nums.size();
        int left = 0;
        int right = len - 1;
        int mid;
        int res;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isDivisionResultSumGreater(nums, nums[mid], threshold)) {
                // sum > threshold
                // ignore left half
                left = mid + 1;
            } else {
                // sum <= threshold
                // ignore right half
                right = mid - 1;
                res = nums[mid];
            }
        }
        return finalSmallestDivisor(res, nums, threshold);
        // if (res < threshold) {
        // }
        return res;
    }
};