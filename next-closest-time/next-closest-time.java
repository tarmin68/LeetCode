class Solution {
    public String nextClosestTime(String time) {
        int[] timeArray = getDigits(time);
        int timeVal = getTime(timeArray);
        
        int[] next = new int[4];
        int min = Integer.MAX_VALUE;
        int[] minTime = new int[4];
        for(int i = 0; i < 4; i++){
            next[0] = timeArray[i];
            for(int j = 0; j < 4; j++){
                next[1] = timeArray[j];
                for(int k = 0; k < 4; k++){
                    next[2] = timeArray[k];
                    for(int l = 0; l < 4; l++){
                        next[3] = timeArray[l];
                        if(isValid(next)){
                            int nextVal = getTime(next);
                            if(nextVal <= timeVal)
                                nextVal += (24 * 60);
                            if(nextVal - timeVal < min){
                                min = nextVal - timeVal;
                                for(int m = 0; m < 4; m++){
                                    minTime[m] = next[m];
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return "" + minTime[0] + "" + minTime[1] + ":" + minTime[2] + "" + minTime[3];
    }
    
    public int[] getDigits(String time){
        int[] ans = new int[4];
        ans[0] = time.charAt(0) - '0';
        ans[1] = time.charAt(1) - '0';
        ans[2] = time.charAt(3) - '0';
        ans[3] = time.charAt(4) - '0';
        
        return ans;
    }
    
    public int getTime(int[] timeArray){
        int ans = 0;
        ans += timeArray[0] * 10 * 60;
        ans += timeArray[1] * 60;
        ans += timeArray[2] * 10;
        ans += timeArray[3];
        
        return ans;
    }
    
    public boolean isValid(int[] timeArray){
        if(timeArray[0] > 2)
            return false;
        if(timeArray[0] == 2 && timeArray[1] > 3)
            return false;
        if(timeArray[2] > 5)
            return false;
        
        return true;
    }
}