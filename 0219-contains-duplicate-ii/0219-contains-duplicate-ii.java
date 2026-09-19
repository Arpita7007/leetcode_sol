class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> wid = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(wid.contains(nums[i])){
                return true;
            }
            wid.add(nums[i]);

            if(wid.size() > k){
                wid.remove(nums[i - k]);
            }
        }
        return false;
    }
}