class Solution {
    public int trap(int[] height) {
        int[] preMax = new int[height.length];
        int[] nextMax = new int[height.length];
        
        int max = 0;
        for(int i = 0; i < height.length; i++){
            preMax[i] = max;
            max = Math.max(max, height[i]);
        }
        
        max = 0;
        for(int i = height.length - 1; i >= 0; i--){
            nextMax[i] = max;
            max = Math.max(max, height[i]);
        }
        
        int count = 0;
        for(int i = 0; i < height.length; i++){
            int minH = Math.min(preMax[i], nextMax[i]);
            count += Math.max(0, minH - height[i]);
        }
        
        return count;
    }
}