class Solution {
    public String convert(String s, int numRows) {
       if(numRows == 1) return s;
        
       StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            res.append(getString(s, i, numRows));
        }
        
        return res.toString();
    }
    
    public String getString(String s, int rowNum, int numRows){
        StringBuilder res = new StringBuilder();
        if(rowNum == 0 || rowNum == numRows - 1){
            for(int i = rowNum; i < s.length(); i += (2 * numRows - 2)){
                res.append(s.charAt(i) + "");
            }
        }
        else{
            if(rowNum < s.length()){
                res.append(s.charAt(rowNum) + "");
            }
            int i = 2 * numRows - 2 - rowNum;
            for(; i < s.length(); i += (2 * numRows - 2)){
                res.append(s.charAt(i) + "");
                if(i + 2 * rowNum < s.length()){
                    res.append(s.charAt(i + 2 * rowNum) +"");
                }
            }
        }
        
        return res.toString();
    }
}