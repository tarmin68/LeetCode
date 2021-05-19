class TimeMap {
    HashMap<String, TreeMap<Integer, String>> keyMap;
    /** Initialize your data structure here. */
    public TimeMap() {
        keyMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.putIfAbsent(key, new TreeMap<Integer, String>());
        keyMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(keyMap.get(key) != null){
            TreeMap<Integer, String> currTreeMap = keyMap.get(key);
            if(currTreeMap.floorKey(timestamp) != null){
                Integer time = currTreeMap.floorKey(timestamp);
                return currTreeMap.get(time);
            }
            else{
                return "";
            }
        }
        else{
            return "";
        }
    }
    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */