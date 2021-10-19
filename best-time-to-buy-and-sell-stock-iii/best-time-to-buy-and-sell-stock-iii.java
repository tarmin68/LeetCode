class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] profits = new int[n + 1][4];
        
        profits[0][0] = Integer.MIN_VALUE;
        profits[0][2] = Integer.MIN_VALUE;
        
        for(int i = 1; i <= n; i++){
            profits[i][0] = Math.max(profits[i - 1][0], - prices[i - 1]);
            profits[i][1] = Math.max(profits[i - 1][1], profits[i - 1][0] + prices[i - 1]);
            profits[i][2] = Math.max(profits[i - 1][2], profits[i - 1][1] - prices[i - 1]);
            profits[i][3] = Math.max(profits[i - 1][3], profits[i - 1][2] + prices[i - 1]);
        }
        
        return Math.max(0, Math.max(profits[n][1], profits[n][3]));
    }
}