class Solution {
    public int shortestWay(String source, String target) {
        int i = 0;
        int count = 0;
        while(i < target.length()){
            int max = getMaxSub(source, target, i);
            if(max == 0)
                return -1;
            count++;
            i += max;
        }
        
        return count;
    }
    
    public int getMaxSub(String source, String target, int idx){
        int count = 0;
        int i = 0;
        
        while(i < source.length() && idx < target.length()){
            if(source.charAt(i) == target.charAt(idx)){
                count++;
                idx++;
            }
            i++;
        }
        
        return count;
    }
}