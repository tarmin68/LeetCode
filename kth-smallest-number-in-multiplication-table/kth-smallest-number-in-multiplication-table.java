class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int h = m * n;
        
        int ans = 1;
        while(l <= h){
            int mid = (h - l) / 2 + l;
            if(isEnough(m, n, k, mid)){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean isEnough(int m, int n, int k, int num){
        int count = 0;
        for(int i = 0; i < m; i++){
            count += Math.min((num / (i + 1)), n);
        }
        
        return count >= k;
    }
}