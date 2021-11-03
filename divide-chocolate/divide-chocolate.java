class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int totalSum = 0;
        
        for(int i = 0; i < sweetness.length; i++){
            totalSum += sweetness[i];
        }
        
        int l = 1;
        int h = totalSum + 1;
        int ans = 1;
        while(l <= h){
            int mid = (h - l) / 2 + l;
            if(canCut(sweetness, k + 1, mid)){
                ans = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return ans;
    }
    
    public boolean canCut(int[] sweetness, int k, int minVal){
        int sum = 0;
        
        for(int i = 0; i < sweetness.length; i++){
            sum += sweetness[i];
            if(sum >= minVal){
                k--;
                sum = 0;
            }
        }
        
        return k <= 0;
    }
}