class Solution {
    public String multiply(String num1, String num2) {
        String result = "0";
        
        if(num1.equals("0") || num2.equals("0"))
            return result;
        
        for(int i = num1.length() - 1; i >= 0; i--){
            String res = time(num2, num1.charAt(i) - '0');
            for(int j = 0; j < num1.length() - 1 - i; j++){
                res += "0";
            }
            result = pluse(res, result);
        }
        
        return result;
    }
    
    public String time(String num1, int num2){
        String res = "";
        
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            int time = (num1.charAt(i) - '0') * num2 + carry;
            res = (time % 10) + res;
            carry = time / 10;
        }
        
        if(carry != 0)
            res = carry + res;
        
        return res;
    }
    
    public String pluse(String num1, String num2){
        String res = "";
        int i = 0;
        int carry = 0;
        while(i < num1.length() || i < num2.length()){
            int digit1 = 0;
            if(i < num1.length())
                digit1 = num1.charAt(num1.length() - 1 - i) - '0';
            int digit2 = 0;
            if(i < num2.length())
                digit2 = num2.charAt(num2.length() - 1 - i) - '0';
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            res = (sum % 10) + res;
            i++;
        }
        
        if(carry != 0)
            res = carry + res;
        
        return res;
    }
}