class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] availBills = new int[21];
        
        for(int i = 0; i < bills.length; i++){
            availBills[bills[i]]++;
            int rem = bills[i] - 5;
            while(rem >=10 && availBills[10] > 0){
                rem -= 10;
                availBills[10]--;
            }
            while(rem >=5 && availBills[5] > 0){
                rem -= 5;
                availBills[5]--;
            }
            if(rem != 0) return false;
        }
        
        return true;
    }
}