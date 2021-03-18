class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length - 1; i++){
            if(compare(words[i], words[i + 1], order) == 1) return false;
        }
        
        return true;
    }
    
    public int compare(String s1, String s2, String order){
        for(int i = 0; i < s1.length() && i < s2.length(); i++){
            if(order.indexOf(s1.charAt(i)) > order.indexOf(s2.charAt(i)))
                return 1;
            else if(order.indexOf(s1.charAt(i)) < order.indexOf(s2.charAt(i)))
                return -1;
        }
        if(s1.length() < s2.length()) return -1;
        else if(s1.length() > s2.length()) return 1;
        
        return 0;
    }
}