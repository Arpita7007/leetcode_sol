class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int requiredUniqueChars = 0;
        for (int count : targetCount) {
            if (count > 0) {
                requiredUniqueChars++;
            }
        }

        int[] windowCount = new int[128];
        int formedUniqueChars = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount[rightChar]++;

            if (targetCount[rightChar] > 0 && windowCount[rightChar] == targetCount[rightChar]) {
                formedUniqueChars++;
            }

            while (formedUniqueChars == requiredUniqueChars) {
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    formedUniqueChars--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}