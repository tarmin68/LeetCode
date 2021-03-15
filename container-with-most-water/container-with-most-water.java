class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int second = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        
        while(first < second){
            int area = (second - first) * Math.min(height[first],  height[second]);
            maxArea = Math.max(maxArea, area);
            if(height[first] < height[second]){
                first++;
            }
            else{
                second--;
            }
        }
        
        return maxArea;
    }
}