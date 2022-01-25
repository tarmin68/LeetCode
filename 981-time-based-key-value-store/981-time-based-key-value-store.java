class TimeMap {
    HashMap<String, ArrayList<Integer>> timeMap;
    HashMap<String, ArrayList<String>> valueMap;
    

    public TimeMap() {
        timeMap = new HashMap();
        valueMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<Integer>());
        timeMap.get(key).add(timestamp);
        valueMap.putIfAbsent(key, new ArrayList<String>());
        valueMap.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        int idx = findIdx(key, timestamp);
        if(idx == -1)
            return "";
        
        return valueMap.get(key).get(idx);
    }
    
    public int findIdx(String key, int timestamp){
        if(timeMap.get(key) == null)
            return -1;
        
        ArrayList<Integer> times = timeMap.get(key);
        int lo = 0;
        int hi = times.size() - 1;
        int ans = -1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(times.get(mid) == timestamp)
                return mid;
            else if(times.get(mid) < timestamp){
                ans = mid;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */