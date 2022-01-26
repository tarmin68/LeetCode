class SnapshotArray {
    int snap_id;
    int length;
    HashMap<Integer, TreeMap<Integer, Integer>> idxMap;

    public SnapshotArray(int length) {
        snap_id = 0;
        this.length = length;
        idxMap = new HashMap();
    }
    
    public void set(int index, int val) {
        idxMap.putIfAbsent(index, new TreeMap());
        idxMap.get(index).put(snap_id, val);
    }
    
    public int snap() {
        snap_id++;
        return snap_id - 1;
    }
    
    public int get(int index, int snap_id) {
        if(idxMap.get(index) == null)
            return 0;
        
        TreeMap<Integer, Integer> currMap = idxMap.get(index);
        if(currMap.floorKey(snap_id) == null)
            return 0;
        
        int floorKey = currMap.floorKey(snap_id);
        return currMap.get(floorKey);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */