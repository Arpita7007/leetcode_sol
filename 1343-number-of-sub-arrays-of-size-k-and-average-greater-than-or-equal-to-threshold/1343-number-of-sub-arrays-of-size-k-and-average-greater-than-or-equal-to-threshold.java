class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int targetSum = threshold * k;
        int currSum = 0;

        for(int i=0; i<k; i++){
            currSum += arr[i];
        }

        int count = currSum >= targetSum ? 1:0;
        for(int i=k; i<arr.length; i++){
            currSum += arr[i] - arr[i-k];
            if(currSum >= targetSum){
                count++;
            }
        }
        return count;
    }
}