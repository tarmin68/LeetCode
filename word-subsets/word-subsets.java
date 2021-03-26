class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] BCounts = getCount(B);
            
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < A.length; i++){
            if(isSubset(BCounts, getCount(A[i])))
            res.add(A[i]);
        }
        
        return res;
    }
    
    public int[] getCount(String word){
        int[] res = new int[26];
        for(int i = 0; i < word.length(); i++){
            res[word.charAt(i) - 'a']++;
        }
        
        return res;
    }
    
    public int[] getCount(String[] words){
        int[] res = new int[26];
        for(int i = 0; i < words.length; i++){
            int[] currCount = new int[26];
            for(int j = 0; j < words[i].length(); j++){
                currCount[words[i].charAt(j) - 'a']++;
            }
            for(int k = 0; k < 26; k++){
                res[k] = Math.max(res[k], currCount[k]);
            }
        }
        
        return res;
    }
    
    public boolean isSubset(int[] count1, int[] count2){
        for(int i = 0; i < 26; i++){
            if(count1[i] > count2[i])
                return false;
        }
        return true;
    }
}