class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int row = 0;
        int col = 0;
        int idx = 0;
        
        while(row < rows){
            if(col + sentence[idx].length() <= cols){
                col += sentence[idx].length() + 1;
                if(col >= cols){
                    row++;
                    col = 0;
                }
                
                idx++;
                if(idx == sentence.length){
                    count++;
                    idx = 0;
                }
            }
            else{
                row++;
                col = 0;
            }
        }
        
        return count;
    }
}