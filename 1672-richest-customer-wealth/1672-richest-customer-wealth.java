class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] customers : accounts){
            int curr = 0;
            for(int bank : customers){
                curr += bank;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}