class Solution {
    public int reverse(int x) {
        int n = Math.abs(x);
        int lowerLimit = -2147483648;
        int upperLimit = 2147483647;
        int rev = 0;
        int temp;
        int digit;
        while (n > 0) {
            digit = n % 10;
            temp = rev * 10 + digit;
            if (rev == ((temp - digit) / 10)) {
                rev = rev * 10 + digit;
            } else {
                return 0;
            }
            n = n / 10;
        }
        if (x < 0) {
            rev *= (-1);
        }
        if (rev >= lowerLimit && rev <= upperLimit) {
            System.out.println(rev);
            return rev;
        }
        return 0;
    }
}