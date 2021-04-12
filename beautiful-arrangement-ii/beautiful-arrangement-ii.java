class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        
        int sign = 1;
        for(int i = k; i >= 1; i--){
            ans[k - i + 1] = ans[k - i] + (i * sign);
            sign *= -1;
        }
        
        if(k < n - 1){
            ans[k + 1] = ans[1] + 1;
        }
        for(int i = k + 2; i < n; i++){
            ans[i] = ans[i - 1] + 1;
        }
        
        return ans;
    }
}