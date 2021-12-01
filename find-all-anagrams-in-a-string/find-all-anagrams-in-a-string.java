class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        
        HashMap<ArrayList<Integer>, Integer> subMap = new HashMap();
        
        ArrayList<Integer> pFreq = getFreq(p);
        
        ArrayList<Integer> sFreq = new ArrayList();
        for(int i = 0; i < 26; i++){
            sFreq.add(0);
        }
        
        subMap.put(new ArrayList<Integer>(sFreq), -1);
        
        for(int i = 0; i < s.length(); i++){
            sFreq.set(s.charAt(i) - 'a', sFreq.get(s.charAt(i) - 'a') + 1);
            ArrayList<Integer> diff = getDiff(sFreq, pFreq);
            if(subMap.containsKey(diff)){
                int idx = subMap.get(diff);
                res.add(idx + 1);
            }
            subMap.put(new ArrayList<Integer>(sFreq), i);
        }
        
        return res;
    }
    
    public ArrayList<Integer> getFreq(String s){
        ArrayList<Integer> res = new ArrayList();
        for(int i = 0; i < 26; i++){
            res.add(0);
        }
        
        for(int i = 0; i < s.length(); i++){
            res.set(s.charAt(i) - 'a', res.get(s.charAt(i) - 'a') + 1);
        }
        
        return res;
    }
    
    public ArrayList<Integer> getDiff(ArrayList<Integer> s1Freq, ArrayList<Integer> s2Freq){
        ArrayList<Integer> res = new ArrayList();
        
        for(int i = 0; i < 26; i++){
            res.add(s1Freq.get(i) - s2Freq.get(i));
        }
        
        return res;
    }
}