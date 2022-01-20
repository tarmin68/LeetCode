class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int temp = x;
        int reverse = 0;
        while(x != 0){
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        
        if(reverse == temp) return true;
        return false;
    }
}