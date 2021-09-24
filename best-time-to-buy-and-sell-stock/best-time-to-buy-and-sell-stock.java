class Solution {
    public int maxProfit(int[] prices) {
        int[] mins = new int[prices.length];
        int[] maxes = new int[prices.length];
        
        mins[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            mins[i] = Math.min(mins[i - 1], prices[i]);
        }
        
        int maxProfit = 0;
        maxes[prices.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            maxes[i] = Math.max(maxes[i + 1], prices[i]);
            maxProfit = Math.max(maxProfit, maxes[i + 1] - mins[i + 1]);
        }
        maxProfit = Math.max(maxProfit, maxes[0] - mins[0]);
        
        return maxProfit;
    }
}