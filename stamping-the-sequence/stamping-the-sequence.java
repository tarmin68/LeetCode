class Solution {
    char[] targetChars;
    
    public int[] movesToStamp(String stamp, String target) {
        
        targetChars = target.toCharArray();
        Stack<Integer> s = new Stack();
        
        boolean hasChanged = true;
        while(hasChanged){
            hasChanged = false;
            for(int i = 0; i + stamp.length() <= target.length(); i++){
                if(canBeStamped(stamp, i)){
                    s.push(i);
                    hasChanged = true;
                }
            }
        }
        
        
        for(int i = 0; i < target.length(); i++){
            if(targetChars[i] != '?')
                return new int[0];
        }
        
        int[] res = new int[s.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = s.pop();
        }
        
        return res;
    }
    
    public boolean canBeStamped(String stamp, int i){
        boolean hasChanged = false;
        for(int j = 0; j < stamp.length(); j++){
            if(targetChars[i + j] == '?')
                continue;
            if(targetChars[i + j] != stamp.charAt(j))
                return false;
            hasChanged = true;
        }
        
        if(hasChanged){
            for(int j = 0; j < stamp.length(); j++){
                targetChars[i + j] = '?';
            }
        }
        
        return hasChanged;
    }
}