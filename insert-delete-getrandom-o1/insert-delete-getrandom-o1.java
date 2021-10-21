class RandomizedSet {
    HashMap<Integer, Integer> indexMap;
    ArrayList<Integer> values;

    public RandomizedSet() {
        indexMap = new HashMap();
        values = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(indexMap.get(val) != null)
            return false;
        else{
            values.add(val);
            indexMap.put(val, values.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(indexMap.get(val) == null)
            return false;
        else{
            int idx = indexMap.get(val);
            int temp = values.get(values.size() - 1);
            values.set(idx, temp);
            indexMap.put(temp, idx);
            values.remove(values.size() - 1);
            indexMap.remove(val);
            return true;
        }
    }
    
    public int getRandom() {
        return values.get(new Random().nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */