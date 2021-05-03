class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> tSet = new TreeSet();
        
        tSet.add(bulbs[0]);
        for(int i = 1; i < bulbs.length; i++){
            Integer floor = tSet.floor(bulbs[i]);
            if(floor != null && (bulbs[i] - floor - 1) == k)
                return i + 1;
            Integer ceil = tSet.ceiling(bulbs[i]);
            if(ceil != null && (ceil - bulbs[i] - 1) == k)
                return i + 1;
            tSet.add(bulbs[i]);
        }
        
        return -1;
    }
}