class Solution {
    long mod = 1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHDiff = 0;
        long maxVDiff = 0;
        
        int currH = 0;
        for(int i = 0; i < horizontalCuts.length; i++){
            maxHDiff = Math.max(maxHDiff, horizontalCuts[i] - currH);
            currH = horizontalCuts[i];
        }
        maxHDiff = Math.max(maxHDiff, h - currH);
        
        int currV = 0;
        for(int i = 0; i < verticalCuts.length; i++){
            maxVDiff = Math.max(maxVDiff, verticalCuts[i] - currV);
            currV = verticalCuts[i];
        }
        maxVDiff = Math.max(maxVDiff, w - currV);
        
        return (int)((maxHDiff * maxVDiff) % mod);
    }
}