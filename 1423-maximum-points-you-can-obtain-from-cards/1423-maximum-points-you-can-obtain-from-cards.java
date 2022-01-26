class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int min = Integer.MAX_VALUE;
        
        int totalSum = 0;
        for(int i = 0; i < cardPoints.length; i++){
            totalSum += cardPoints[i];
        }
        
        int sum = 0;
        for(int i = 0; i < cardPoints.length - k; i++){
            sum += cardPoints[i];
        }
        min = Math.min(min, sum);
        
        for(int i = 0; i < k; i++){
            sum = sum - cardPoints[i] + cardPoints[cardPoints.length - k + i];
            min = Math.min(min, sum);
        }
        
        return totalSum - min;
    }
}