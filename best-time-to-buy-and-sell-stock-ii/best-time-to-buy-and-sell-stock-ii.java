class Solution {
    Integer[][] profits;
    public int maxProfit(int[] prices) {
        profits = new Integer[prices.length][2];
        return getProfit(prices, 0, false);
    }
    
    public int getProfit(int[] prices, int day, boolean hold){
        if(day >= prices.length)
            return 0;
        
        if(hold && profits[day][1] != null)
            return profits[day][1];
        if(!hold && profits[day][0] != null)
            return profits[day][0];
        
        if(hold){
            int profit1 = prices[day] + getProfit(prices, day + 1, false);
            int profit2 = getProfit(prices, day + 1, true);
            return profits[day][1] = Math.max(profit1, profit2);
        }
        else{
            int profit1 = -prices[day] + getProfit(prices, day + 1, true);
            int profit2 = getProfit(prices, day + 1, false);
            return profits[day][0] = Math.max(profit1, profit2);
        }
    }
}