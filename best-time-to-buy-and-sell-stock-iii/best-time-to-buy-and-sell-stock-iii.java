class Solution {
    Integer[][][] maxes;
    
    public int maxProfit(int[] prices) {
        maxes = new Integer[prices.length][2][5];
        
        return getMax(prices, 0, 1, 0);
    }
    
    public int getMax(int[] prices, int day, int canBuy, int buyCount){
        if(day >= prices.length)
            return 0;
        
        if(maxes[day][canBuy][buyCount] != null)
            return maxes[day][canBuy][buyCount];
        
        if(canBuy == 1 && buyCount < 3){
            int c1 = - prices[day] + getMax(prices, day + 1, 0, buyCount + 1);
            int c2 = getMax(prices, day + 1, 1, buyCount);
            
            return maxes[day][canBuy][buyCount] = Math.max(c1, c2);
        }
        else if(canBuy == 0 && buyCount < 4){
            int c1 = prices[day] + getMax(prices, day + 1, 1, buyCount + 1);
            int c2 = getMax(prices, day + 1, 0, buyCount);
            
            return maxes[day][canBuy][buyCount] = Math.max(c1, c2);
        }
        
        return 0;
    }
}