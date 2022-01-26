class SnapshotArray {
    int snapId;
    HashMap<Pair<Integer, Integer>, Integer> myMap;

    public SnapshotArray(int length) {
        snapId = 0;
        myMap = new HashMap();
    }
    
    public void set(int index, int val) {
        myMap.put(new Pair(snapId, index), val);
    }
    
    public int snap() {
        snapId++;
        return snapId - 1;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id >= 0 && myMap.get(new Pair(snap_id, index)) == null){
            snap_id--;
        }
        if(snap_id == -1)
            return 0;
        return myMap.get(new Pair(snap_id, index));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */