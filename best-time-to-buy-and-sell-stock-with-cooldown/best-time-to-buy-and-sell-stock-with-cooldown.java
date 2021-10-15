class Solution {
    Integer[][] maxes;
    public int maxProfit(int[] prices) {
        maxes = new Integer[prices.length][2];
        return getMax(prices, 0, true);
    }
    
    public int getMax(int[] prices, int day, boolean canBuy){
        if(day >= prices.length)
            return 0;
        
        if(canBuy && maxes[day][1] != null)
            return maxes[day][1];
        if(!canBuy && maxes[day][0] != null)
            return maxes[day][0];
        
        if(canBuy){
            int c1 = - prices[day] + getMax(prices, day + 1, false);
            
            int c2 = getMax(prices, day + 1, true);
            
            return maxes[day][1] = Math.max(c1, c2);
        }
        else{
            int c1 = prices[day] + getMax(prices, day + 2, true);
            
            int c2 = getMax(prices, day + 1, false);
            
            return maxes[day][0] = Math.max(c1, c2);
        }
    }
}