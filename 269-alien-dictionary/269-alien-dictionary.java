class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> charCount = new HashMap();
        HashMap<Character, ArrayList<Character>> charNexts = new HashMap();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                charCount.putIfAbsent(words[i].charAt(j), 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            boolean isFound = false;
            for(int j = 0; j < words[i].length() && j < words[i + 1].length(); j++){
                if(words[i].charAt(j) != words[i + 1].charAt(j)){
                    charNexts.putIfAbsent(words[i].charAt(j), new ArrayList<Character>());
                    charNexts.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    charCount.put(words[i + 1].charAt(j), charCount.get(words[i + 1].charAt(j)) + 1);
                    isFound = true;
                    break;
                }
            }
            if(!isFound && words[i].length() > words[i + 1].length())
                return "";
        }
        
        int allChars = charCount.keySet().size();
        Queue<Character> q = new LinkedList();
        
        for(Character c : charCount.keySet()){
            if(charCount.get(c) == 0){
                q.add(c);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            char currChar = q.remove();
            res.append(currChar);
            if(charNexts.get(currChar) != null){
                for(char next : charNexts.get(currChar)){
                    int count = charCount.get(next);
                    if(count != 0){
                        count--;
                        charCount.put(next, count);
                        if(count == 0){
                            q.add(next);
                        }
                    }
                }
            }
        }
        
        if(res.length() != allChars)
            return "";
        else
            return res.toString();
    }
}