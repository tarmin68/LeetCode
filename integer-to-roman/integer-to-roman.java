class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        
        int thousands = num / 1000;
        for(int i = 0; i < thousands; i++){
            res.append("M");
        }
        
        num = num % 1000;
        int hundreds = num / 100;
        switch(hundreds){
            case 1:
            case 2:
            case 3:
                for(int i = 0; i < hundreds; i++){
                    res.append("C");
                }
                break;
            case 4:
                res.append("CD");
                break;
            case 5:
                res.append("D");
                break;
            case 6:
            case 7:
            case 8:
                res.append("D");
                for(int i = 0; i < hundreds - 5; i++){
                    res.append("C");
                }
                break;
            case 9:
                res.append("CM");
        }
        
        num = num % 100;
        int tens = num / 10;
        switch(tens){
            case 1:
            case 2:
            case 3:
                for(int i = 0; i < tens; i++){
                    res.append("X");
                }
                break;
            case 4:
                res.append("XL");
                break;
            case 5:
                res.append("L");
                break;
            case 6:
            case 7:
            case 8:
                res.append("L");
                for(int i = 0; i < tens - 5; i++){
                    res.append("X");
                }
                break;
            case 9:
                res.append("XC");
        }
        
        num = num % 10;
        int ones = num;
        switch(ones){
            case 1:
            case 2:
            case 3:
                for(int i = 0; i < ones; i++){
                    res.append("I");
                }
                break;
            case 4:
                res.append("IV");
                break;
            case 5:
                res.append("V");
                break;
            case 6:
            case 7:
            case 8:
                res.append("V");
                for(int i = 0; i < ones - 5; i++){
                    res.append("I");
                }
                break;
            case 9:
                res.append("IX");
        }
       
        return res.toString();
    }
}