class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        long maxSum = 0;
        long currSum = 0;

        for(int right = 0; right < nums.length; right++){
            int rightVal = nums[right];
            map.put(rightVal, map.getOrDefault(rightVal, 0)+1);
            currSum += rightVal;

            while(map.get(rightVal)>1 || (right - left + 1) > k){
                int leftVal = nums[left];
                map.put(leftVal, map.get(leftVal)-1);
                if(map.get(leftVal) == 0){
                    map.remove(leftVal);
                }
                currSum -= leftVal;
                left++;
            }
            if(right - left + 1 == k){
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}                                                                                                                                              