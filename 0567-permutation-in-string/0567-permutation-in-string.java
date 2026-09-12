class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            counts[rightChar - 'a']--;

            // If count is negative, shrink window from left until it's non-negative
            while (counts[rightChar - 'a'] < 0) {
                char leftChar = s2.charAt(left);
                counts[leftChar - 'a']++;
                left++;
            }

            // Check if valid window length matches s1.length()
            if (right - left + 1 == s1.length()) {
                return true;
            }

            right++;
        }

        return false;
    }
}