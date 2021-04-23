class Solution {
    public int countBinarySubstrings(String s) {
        int subCount = 0;
        int zeroCount = 0;
        int oneCount = 0;
        
        int i = 0;
        while(i < s.length()){
            while(i < s.length() && s.charAt(i) == '0'){
                zeroCount++;
                i++;
            }
            subCount += Math.min(zeroCount, oneCount);
            oneCount = 0;
            while(i < s.length() && s.charAt(i) == '1'){
                oneCount++;
                i++;
            }
            subCount += Math.min(zeroCount, oneCount);
            zeroCount = 0;
        }
        
        return subCount;
    }
}