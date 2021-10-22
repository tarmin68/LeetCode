class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            int size = words[i].length();
            for(int j = size - 1; j >= 0; j--){
                res.append(words[i].charAt(j));
            }
            res.append(" ");
        }
        
        return res.toString().trim();
    }
}