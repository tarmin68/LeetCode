class Solution {
    int min = Integer.MAX_VALUE;
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        getDistance(workers, bikes, 0);
        return min;
    }
    
    public void getDistance(int[][] workers, int[][] bikes, int idx){
        if(idx == workers.length){
            min = Math.min(min, calcDist(workers, bikes));
        }
                             
        for(int i = idx; i < bikes.length; i++){
            bikes = swap(bikes, idx, i);
            getDistance(workers, bikes, idx + 1);
            bikes = swap(bikes, idx, i);
        }                     
    }
    
    public int calcDist(int[][] workers, int[][] bikes){
        int dist = 0;
        for(int i = 0; i < workers.length; i++){
            dist += (Math.abs(workers[i][0] - bikes[i][0]) + Math.abs(workers[i][1] - bikes[i][1]));
        }
        return dist;
    }
    
    public int[][] swap(int[][] bikes, int idx1, int idx2){
        int[] temp = bikes[idx1];
        bikes[idx1] = bikes[idx2];
        bikes[idx2] = temp;
        
        return bikes;
    }
}