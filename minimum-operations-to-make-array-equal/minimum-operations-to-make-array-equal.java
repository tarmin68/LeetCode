class Solution {
    public int minOperations(int n) {
        int count = 0;
        int i = 0;
        while((2 * i + 1) < n){
            count += (n - 2 * i - 1);
            i++;
        }
        
        return count;
    }
}