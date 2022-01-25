class Solution {
    public int longestStrChain(String[] words) {
        Set<String> allWords = new HashSet();
        Queue<String> q = new LinkedList();
        
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for(int i = 0; i < words.length; i++){
            allWords.add(words[i]);
        }
        
        int max = 0;
        for(int i = words.length - 1; i >= 0; i--){
            if(allWords.contains(words[i])){
                q.add(words[i]);
                
                int level = 0;
                while(!q.isEmpty()){
                    int size = q.size();
                    for(int k = 0; k < size; k++){
                        String currWord = q.remove();
                        for(int j = 0; j < currWord.length(); j++){
                            String newWord = currWord.substring(0, j) + "" + currWord.substring(j + 1);
                            if(allWords.contains(newWord)){
                                q.add(newWord);
                                allWords.remove(newWord);
                            }
                        }
                    }
                    level++;
                }
                max = Math.max(max, level);
            }
        }
        
        return max;
    }
}