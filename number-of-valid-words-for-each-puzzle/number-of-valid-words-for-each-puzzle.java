class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] wordsMap = new int[words.length];
        int[] puzzlesMap = new int[puzzles.length];
        int[] puzzlesFirstChar = new int[puzzles.length];
        
        for(int i = 0; i < words.length; i++){
            int currMap = 0;
            for(int j = 0; j < words[i].length(); j++){
                currMap |= 1 << (words[i].charAt(j) - 'a');            
            }
            wordsMap[i] = currMap;
        }
        
        for(int i = 0; i < puzzles.length; i++){
            int currMap = 0;
            puzzlesFirstChar[i] = 1 << (puzzles[i].charAt(0) - 'a');
            for(int j = 0; j < puzzles[i].length(); j++){
                currMap |= 1 << (puzzles[i].charAt(j) - 'a');
            }
            puzzlesMap[i] = currMap;
        }
        
        List<Integer> res = new ArrayList();
        for(int i = 0; i < puzzles.length; i++){
            int count = 0;
            for(int j = 0; j < words.length; j++){
                if((puzzlesMap[i] & wordsMap[j]) == wordsMap[j] && (puzzlesFirstChar[i] & wordsMap[j]) != 0)
                    count++;
            }
            res.add(count);
        }
        return res;
    }
}