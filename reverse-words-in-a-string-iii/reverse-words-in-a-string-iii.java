class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String res = "";
        for(int i = 0; i < words.length; i++){
            res += reverse(words[i]) + " ";
        }
        
        return res.substring(0, res.length() - 1);
    }
    
    public String reverse(String word){
        char[] wordChars = word.toCharArray();
        int l = 0;
        int r = wordChars.length - 1;
        while(l < r){
            char temp = wordChars[l];
            wordChars[l++] = wordChars[r];
            wordChars[r--] = temp;
        }
        
        return new String(wordChars);
    }
};