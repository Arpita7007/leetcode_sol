class Solution {
    public int[] productExceptSelf(int[] nums) {
        //brute force
        int[] ans = new int[nums.length];

        //left elemnt product
        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];

        }

        //right elmnt prod
        int rightProd = 1;
        for(int i=nums.length-1; i>=0; i--){
            ans[i] = ans[i] * rightProd;
            rightProd *= nums[i]; 
        }

        return ans;
        
    }
}