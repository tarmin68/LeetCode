class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] sums = new int[cardPoints.length];
        
        sums[0] = cardPoints[0];
        for(int i = 1; i < cardPoints.length; i++){
            sums[i] = sums[i - 1] + cardPoints[i];
        }
        
        if(k == cardPoints.length){
            return sums[cardPoints.length - 1];
        }
        
        int ans = sums[cardPoints.length - 1] - sums[cardPoints.length - k - 1];
        for(int i = 1; i <= k; i++){
            ans = Math.max(ans, sums[cardPoints.length - 1] - sums[i + cardPoints.length - k - 1] + sums[i - 1]);
        }
        
        return ans;
    }
}