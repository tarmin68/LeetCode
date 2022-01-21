class Solution {
    Integer[] counts;
    Integer[] idxs;
    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        counts = new Integer[sentence.length];
        idxs = new Integer[sentence.length];
        int count = 0;
        int idx = 0;
        
        for(int i = 0; i < rows; i++){
            Pair<Integer, Integer> currRes = fitScreen(sentence, idx, cols);
            idx = currRes.getKey();
            count += currRes.getValue();
        }
        
        return count;
    }
    
    public Pair<Integer, Integer> fitScreen(String[] sentence, int idx, int cols){
        if(counts[idx] != null)
            return new Pair(idxs[idx], counts[idx]);
        
        int count = 0;
        int col = 0;
        int newIdx = idx;
        
        while(col + sentence[newIdx].length() <= cols){
            col += sentence[newIdx].length() + 1;
            newIdx++;
            if(newIdx == sentence.length){
                count++;
                newIdx = 0;
            }
        }
        idxs[idx] = newIdx;
        counts[idx] = count;
        
        return new Pair(newIdx, count);
    }
}