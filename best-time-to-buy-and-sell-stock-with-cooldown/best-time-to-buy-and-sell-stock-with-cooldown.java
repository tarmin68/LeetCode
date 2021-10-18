class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2)
            return 0;
        
        // 0: canBuy 1:CanSell
        int[][] maxProfit = new int[n + 2][2];
        for(int i = n - 1; i >= 0; i--){
            maxProfit[i][0] = Math.max(maxProfit[i + 1][1] - prices[i], maxProfit[i + 1][0]);
            maxProfit[i][1] = Math.max(maxProfit[i + 2][0] + prices[i], maxProfit[i + 1][1]);
        }
        
        return maxProfit[0][0];
    }
    
}