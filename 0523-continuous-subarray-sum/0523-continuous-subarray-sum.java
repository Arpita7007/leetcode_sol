class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        // Base case: remainder 0 occurred at index -1
        remainderMap.put(0, -1);
        
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            // If k is not 0, take the modulo
            int remainder = currentSum % k;
            
            // Handle negative remainders if any (though constraints say nums[i] >= 0, 
            // but good practice if inputs change)
            if (remainder < 0) {
                remainder += k;
            }
            
            if (remainderMap.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Store only the first occurrence of the remainder to maximize the subarray length
                remainderMap.put(remainder, i);
            }
        }
        
        return false;
    }
}