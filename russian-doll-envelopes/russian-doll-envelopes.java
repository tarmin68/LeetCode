class Solution {
    public int maxEnvelopes(int[][] envelopes) {
       Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] == b[0])
                   return b[1] - a[1];
               else
                   return a[0] - b[0];
           }
       });
        
        int[] secondDim = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            secondDim[i] = envelopes[i][1];
        }
        
        return getLIS(secondDim);
    }
    
    public int getLIS(int[] arr){
        int[] dp = new int[arr.length];
        int LIS = 1;
        
        for(int i = 0; i < arr.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            LIS = Math.max(LIS, max);
        }
        
        return LIS;
    }
}