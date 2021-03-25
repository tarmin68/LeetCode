class Solution {
    public int maxDistToClosest(int[] seats) {
        int firstFull = -1;
        int prevFull = -1;
        int maxSpace = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1 && firstFull == -1){
                firstFull = i;
            }
            if(seats[i] == 1){
                maxSpace = Math.max(maxSpace, i - prevFull - 1);
                prevFull = i;
            }
        }
        
        int res = 0;
        if(maxSpace % 2 == 0)
            res = maxSpace / 2;
        else
            res = maxSpace / 2 + 1;
        
        if(seats.length - 1 - prevFull >= res){
            res = seats.length - 1 - prevFull;
        }
        if(firstFull >= res)
            res = firstFull;
        
        return res;
    }
}