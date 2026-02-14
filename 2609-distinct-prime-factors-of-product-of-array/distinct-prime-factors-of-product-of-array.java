class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> res = new HashSet<>();

        for (int n: nums) {
            // completely divide by 2
            if (n % 2 == 0) res.add(2);
            while (n % 2 == 0) n /= 2;
            // completely divide by odds
            for (int odd = 3; odd*odd <= n; odd += 2) {
                if (n % odd == 0) {
                    res.add(odd);
                    while (n % odd == 0) n /= odd;
                }
                if (n == 1) break;
            }
            // remaining, if not 1, then it is prime
            if (n != 1) res.add(n);
        }

        return res.size();
    }
}