class Solution {
    int[] amountCounts;
    public int coinChange(int[] coins, int amount) {
        amountCounts = new int[amount + 1];
        
        return getCount(coins, amount);
    }
    
    public int getCount(int[] coins, int amount){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        
        if(amountCounts[amount] != 0) return amountCounts[amount];
        
        int minCount = Integer.MAX_VALUE;
        for(int coin:coins){
            int remCount = getCount(coins, amount - coin);
            if(remCount != -1 && remCount < minCount)
                minCount = 1 + remCount;
        }
        
        if(minCount != Integer.MAX_VALUE){
            amountCounts[amount] = minCount;
        }
        else{
            amountCounts[amount] = -1;
        }
        
        return amountCounts[amount];
    }
}