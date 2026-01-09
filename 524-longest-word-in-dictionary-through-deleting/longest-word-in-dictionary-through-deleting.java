class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String str: dictionary) {
            if (canFormString(str, s)) {
                if (str.length() > res.length()) res = str;
                else if (str.length() == res.length() && str.compareTo(res) < 0) res = str;
            }
        }
        return res;
    }

    private boolean canFormString(String str, String target) {
        int n = str.length();
        int start = 0;
        int idx;
        for (int i = 0; i < n; i++) {
            idx = target.indexOf(str.charAt(i), start);
            if (idx < 0) return false;
            start = idx + 1;
        }
        return true;
    }
}