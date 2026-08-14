class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int rt = nums.length-1;
            while(left<rt){
                int sum = nums[i] + nums[left] + nums[rt];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[rt]));
                    left++;
                    rt--;

                    while(left<rt && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left<rt && nums[rt] == nums[rt+1]){
                        rt--;
                    }
                } else if(sum<0){
                    left++;
                } else {
                    rt--;
                }
            }
        }
        return result;
    }
}