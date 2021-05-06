class Solution {
    HashMap<Pair<Integer, Integer>, Integer> myMap;
    public int numTrees(int n) {
        myMap = new HashMap();
        return getNum(1, n);
    }
    
    public int getNum(int l, int r){
        if(r < l)
            return 1;
        if(l == r)
            return 1;
        
        if(myMap.get(new Pair(l, r)) != null)
            return myMap.get(new Pair(l, r));
        
        int count = 0;
        for(int i = l; i <= r; i++){
            int leftCount = getNum(l, i - 1);
            int rightCount = getNum(i + 1, r);
            count += leftCount * rightCount;
        }
        
        myMap.put(new Pair(l, r), count);
        return count;
    }
}