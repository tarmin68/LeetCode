class Solution {
    public int arrangeCoins(int n) {
        long l = 1;
        long h = n;
        
        long ans = 1;
        while(l <= h){
            long mid = (h - l) / 2 + l;
            long curr = mid * (mid + 1) / 2;
            if(curr == n)
                return (int) mid;
            else if (curr <= n){
                ans = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return (int) ans;
    }
}