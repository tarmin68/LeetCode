class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            char c = name.charAt(i);
            if(name.charAt(i) != typed.charAt(j))
                return false;
            int count = 0;
            while(i < name.length() && name.charAt(i) == c){
                count++;
                i++;
            }
            while(j < typed.length() && typed.charAt(j) == c){
                count--;
                j++;
            }
            if(count > 0)
                return false;
        }
        
        if(i < name.length() || j < typed.length())
            return false;
        return true;
    }
}