class Solution {
public:
    void ipAddressUtil(vector<string>& res, int startIdx, string& currStr, int count, string& str) {
        if (count > 4 && startIdx == str.size()) {
            res.push_back(currStr);
            return;
        }
        if (count > 4 || startIdx == str.size()) return;
        for (int c = 1; c <= 3; c++) {
            if ((startIdx + c) > str.size()) {
                return;
            }
            string temp = str.substr(startIdx, c);
            if (temp.size() > 1 && temp[0] == '0') return;
            if (stoi(temp) > 255) return;
            if(count < 4) temp.push_back('.');
            currStr.append(temp);
            ipAddressUtil(res, startIdx + c, currStr, count + 1, str);
            currStr.erase(currStr.size() - temp.size(), temp.size());
        }
    }
    vector<string> restoreIpAddresses(string s) {
        string currStr = "";
        vector<string> res;
        ipAddressUtil(res, 0, currStr, 1, s);
        return res;
    }
};