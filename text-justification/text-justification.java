class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        int i = 0;
        int size = 0;
        ArrayList<String> currWords = new ArrayList();
        while(i <= words.length){
            if(i == words.length){
                res.add(getSentence(currWords, maxWidth, true));
                break;
            }
            if(size + words[i].length() > maxWidth){
                res.add(getSentence(currWords, maxWidth, false));
                size = 0;
                currWords = new ArrayList();
            }
            else{
                currWords.add(words[i]);
                size += words[i].length() + 1;
                i++;
            }
        }
        
        return res;
    }
    
    
    public String getSentence(ArrayList<String> words, int maxWidth, boolean last){
        StringBuilder res = new StringBuilder();
        if(last || words.size() == 1){
            int size = 0;
            for(int i = 0; i < words.size() - 1; i++){
                res.append(words.get(i) + " ");
                size += words.get(i).length() + 1;
            }
            res.append(words.get(words.size() - 1));
            size += words.get(words.size() - 1).length();

            for(int i = 0; i < maxWidth - size; i++){
                res.append(" ");
            }
        }
        else{
            int totalWordsSize = 0;
            for(int i = 0; i < words.size(); i++){
                totalWordsSize += words.get(i).length();
            }
            
            int totalSpace = maxWidth - totalWordsSize;
            int spacePos = words.size() - 1;
            int maxSpace = (totalSpace / spacePos);
            if(totalSpace % spacePos != 0)
                maxSpace++;
            int minSpaceNum = maxSpace * spacePos - totalSpace;
            
            int spaceSlot = 0;
            for(int i = 0; i < words.size() - 1; i++){
                res.append(words.get(i));
                if(spaceSlot < spacePos - minSpaceNum){
                    for(int j = 0; j < maxSpace; j++)
                        res.append(" ");
                    spaceSlot++;
                }
                else{
                    for(int j = 0; j < maxSpace - 1; j++)
                        res.append(" ");
                }
            }
            res.append(words.get(words.size() - 1));
        }
        
        return res.toString();
    }
}