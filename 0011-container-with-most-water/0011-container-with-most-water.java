class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
                int width = right - left;
                int currHt = Math.min(height[left], height[right]);
                int area = width * currHt;

                maxWater = Math.max(maxWater, area);
                
                if(height[left] < height[right]){
                    left++;
                } else {
                    right--;
                }
            }

            return maxWater;
    }
}