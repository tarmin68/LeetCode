class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCounts = new int[7];
        int[] botCounts = new int[7];
        int[] disCounts = new int[7];
        
        for(int i = 0; i < tops.length; i++){
            topCounts[tops[i]]++;
            botCounts[bottoms[i]]++;
            disCounts[tops[i]]++;
            if(tops[i] != bottoms[i]){
                disCounts[bottoms[i]]++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < 7; i++){
            if(disCounts[i] >= tops.length)
                min = Math.min(min, tops.length - Math.max(topCounts[i], botCounts[i]));
        }
        
        if(min == Integer.MAX_VALUE)
            return -1;
        
        return min;
    }
}