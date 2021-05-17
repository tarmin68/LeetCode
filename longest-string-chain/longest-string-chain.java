class Solution {
    HashMap<Pair<String, Integer>, Integer> maxes = new HashMap();
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        int max = 0;
        for(int i = 0; i < words.length; i++){
            max = Math.max(max,  getMaxChain(words, i + 1, words[i]));
        }
        
        return max + 1;
    }
    
    public int getMaxChain(String[] words, int idx, String lastWord){
        if(idx >= words.length)
            return 0;
        
        if(maxes.get(new Pair(lastWord, idx)) != null)
            return maxes.get(new Pair(lastWord, idx));
                             
        if(isPredecessor(lastWord, words[idx])){
            int max1 = getMaxChain(words, idx + 1, lastWord);
            int max2 = getMaxChain(words, idx + 1, words[idx]) + 1;
            maxes.put(new Pair(lastWord, idx), Math.max(max1, max2));
        }
        else{
            maxes.put(new Pair(lastWord, idx), getMaxChain(words, idx + 1, lastWord));
        }
        return maxes.get(new Pair(lastWord, idx));
    }
    
    public boolean isPredecessor(String word1, String word2){
        if(word2.length() != word1.length() + 1)
            return false;
        boolean isDiff = false;
        int i = 0;
        int j = 0;
        while( i < word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
                j++;
                continue;
            }
            else{
                if(isDiff)
                    return false;
                else{
                    isDiff = true;
                    j++;
                }
            }
        }
        
        return true;
    }
}