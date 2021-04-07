class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextWord = new int[sentence.length];
        int[] sentenceCount = new int[sentence.length];
        
        int[] wordLength = new int[sentence.length];
        for(int i = 0; i < sentence.length; i++)
            wordLength[i] = sentence[i].length() + 1;
        
        for(int i = 0; i < sentence.length; i++){
            int currWord = i;
            int len = 0;
            int sentNum = 0;
            
            while(len + wordLength[currWord] <= cols + 1){
                len += wordLength[currWord];
                currWord++;
                
                if(currWord == sentence.length){
                    currWord = 0;
                    sentNum++;
                }
            }
            
            nextWord[i] = currWord;
            sentenceCount[i] = sentNum;
        }
        
        int wordIdx = 0;
        int count = 0;
        for(int i = 0; i < rows; i++){
            count += sentenceCount[wordIdx];
            wordIdx = nextWord[wordIdx];
        }
        
        return count;
    }
}