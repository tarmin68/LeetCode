class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<ArrayList<Integer>> charCounts = new HashSet();
        ArrayList<Integer> charCount1 = new ArrayList();
        ArrayList<Integer> charCount2 = new ArrayList();
        for(int i = 0; i < 26; i++){
            charCount1.add(0);
            charCount2.add(0);
        }
        
        for(int i = 0; i < s1.length(); i++){
            int prevCount = charCount1.get(s1.charAt(i) - 'a');
            charCount1.set(s1.charAt(i) - 'a', prevCount + 1);
        }
        
        charCounts.add((ArrayList<Integer>) charCount2.clone());
        for(int i = 0; i < s2.length(); i++){
            int prevCount = charCount2.get(s2.charAt(i) - 'a');
            charCount2.set(s2.charAt(i) - 'a', prevCount + 1);
            
            ArrayList<Integer> diff = getDiff(charCount2, charCount1);
            if(charCounts.contains(diff)){
                return true;
            }
            charCounts.add((ArrayList<Integer>) charCount2.clone());
        }

        return false;
    }
    
    
    public ArrayList<Integer> getDiff(ArrayList<Integer> charCount1, ArrayList<Integer> charCount2){
        ArrayList<Integer> diff = new ArrayList();
        for(int i = 0; i < 26; i++){
            diff.add(0);
        }
        
        for(int i = 0; i < 26; i++){
            diff.set(i, charCount1.get(i) - charCount2.get(i));
        }
        
        return diff;
    }
}