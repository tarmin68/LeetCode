class CombinationIterator {
    int[] charIdx;
    String characters;
    int round = 0;

    public CombinationIterator(String characters, int combinationLength) {
        charIdx = new int[combinationLength];
        this.characters = characters;
        for(int i = 0; i < charIdx.length; i++){
            charIdx[i] = i;
        }
    }
    
    public String next() {
        StringBuilder next = new StringBuilder();
        System.out.println(Arrays.toString(charIdx));
        
        for(int i = 0; i < charIdx.length; i++){
            next.append(characters.charAt(charIdx[i]));
        }
        int i = charIdx.length - 1;
        charIdx[i]++;
        while(i > 0 && charIdx[i] + charIdx.length - 1 - i  == characters.length()){
            i--;
            charIdx[i]++;
        }
        for(int j = i + 1; j < charIdx.length; j++){
            charIdx[j] = charIdx[j - 1] + 1;
        }
        return next.toString();
    }
    
    public boolean hasNext() {
        if(charIdx[charIdx.length - 1] < characters.length())
            return true;
        return false;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */