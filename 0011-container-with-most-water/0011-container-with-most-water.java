class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right)
        {
            int min=Math.min(height[left],height[right]);
            int curArea= Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,curArea);
            // if(height[left]<height[right])
            // {
            //     left++;
            // }
            // else{
            //     right--;
            // }
             while(left < right && height[left] <= min) left++;
            while(left < right && height[right] <= min) right--;
        }
        return maxArea;
    }
}