class Solution {
    Integer[][][] profit;
    
    public int maxProfit(int k, int[] prices) {
        profit = new Integer[prices.length][k + 1][2];
        
        return getMaxProfit(k, prices, 0, 1);
    }
    
    public int getMaxProfit(int k, int[] prices, int day, int canBuy){
        if(day == prices.length || k == 0)
            return 0;
        
        if(profit[day][k][canBuy] != null)
            return profit[day][k][canBuy];
        
        if(canBuy == 1){
            //We buy stock on this day
            int p1 = getMaxProfit(k, prices, day + 1, 0) - prices[day];
            // We don't do anything
            int p2 = getMaxProfit(k, prices, day + 1, 1);
            
            return profit[day][k][canBuy] = Math.max(p1, p2);
        }
        else{
            //We sell stock on this day
            int p1 = getMaxProfit(k - 1, prices, day + 1, 1) + prices[day];
            // We don't do anything
            int p2 = getMaxProfit(k, prices, day + 1, 0);
            
            return profit[day][k][canBuy] = Math.max(p1, p2);
        }
    }
}