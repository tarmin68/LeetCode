class Solution {
    public String addStrings(String num1, String num2) {
        String res = "";
        
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i >= 0 && j >= 0){
            int sum = carry + (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
            carry = sum / 10;
            res = (sum % 10) + res;
            i--;
            j--;
        }
        
        while(i >= 0){
            int sum = carry + (num1.charAt(i) - '0');
            carry = sum / 10;
            res = (sum % 10) + res;
            i--;
        }
        while(j >= 0){
            int sum = carry + (num2.charAt(j) - '0');
            carry = sum / 10;
            res = (sum % 10) + res;
            j--;
        }
        
        if(carry > 0)
            res = carry + res;
        
        return res;
    }
}