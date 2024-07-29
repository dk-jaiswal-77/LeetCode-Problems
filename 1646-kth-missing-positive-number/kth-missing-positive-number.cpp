class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int len = arr.size();
        int left = 0;
        int right = len - 1;
        int mid;
        int lbIdx = len - 1; // lower bound idx
        int miCount = arr[lbIdx] - (lbIdx + 1); // missing integer count upto that index
        while (left <= right) {
            mid = left + (right - left) / 2;
            miCount = arr[mid] - (mid + 1);
            if (miCount >= k) {
                lbIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        cout << "lbIdx: " << lbIdx << endl;
        cout << "miCount: " << miCount << endl;
        miCount = arr[lbIdx] - (lbIdx + 1);
        if (miCount < k) {
            return (arr.back() + (k - miCount));
        } else {
            int idx = lbIdx;
            int res = arr[lbIdx] - 1;
            while(miCount > k) {
                if(res != arr[idx]) {
                    miCount--;
                    res--;
                } else if (idx > 0) {
                    idx--;
                }
            }
            return res;
        }
    }
};