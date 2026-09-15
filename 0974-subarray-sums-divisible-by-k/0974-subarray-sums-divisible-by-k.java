class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Frequency array to store count of remainders 0 to k-1
        int[] remainderCount = new int[k];
        
        // Base case: prefix sum of 0 has a remainder of 0
        remainderCount[0] = 1;
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            // Calculate remainder and handle negative numbers
            int rem = prefixSum % k;
            if (rem < 0) {
                rem += k;
            }
            
            // Add the frequency of the current remainder to count
            count += remainderCount[rem];
            
            // Increment the frequency of this remainder
            remainderCount[rem]++;
        }
        
        return count;
    }
}