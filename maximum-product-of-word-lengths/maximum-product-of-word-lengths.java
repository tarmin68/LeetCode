class Solution {
    public int maxProduct(String[] words) {
        int[][] charCounts = new int[words.length][26];
        
        for(int i = 0; i < words.length; i++){
            charCounts[i] = getCharCounts(words[i]);
        }
        
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(!hasCommon(charCounts[i], charCounts[j]))
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        
        return max;
    }
    
    public int[] getCharCounts(String word){
        int[] res = new int[26];
        
        for(int i = 0; i < word.length(); i++){
            res[word.charAt(i) - 'a']++;
        }
        
        return res;
    }
    
    public boolean hasCommon(int[] charCount1, int[] charCount2){
        for(int i = 0; i < 26; i++){
            if(charCount1[i] != 0 && charCount2[i] != 0)
                return true;
        }
        
        return false;
    }
}