class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            res = getLCP(res, strs[i]);
        }
        
        return res;
    }
    
    public String getLCP(String first, String second){
        StringBuilder res = new StringBuilder();
        int i = 0; 
        while(i < first.length() && i < second.length()){
            if(first.charAt(i) == second.charAt(i)){
                res.append(first.charAt(i) + "");
            }
            else{
                return res.toString();
            }
            i++;
        }
        
        return res.toString();
    }
}