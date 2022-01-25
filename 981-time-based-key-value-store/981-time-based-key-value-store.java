class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> keyMap;
    /** Initialize your data structure here. */
    public TimeMap() {
        keyMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.putIfAbsent(key, new ArrayList<Pair<Integer, String>>());
        keyMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(keyMap.get(key) != null){
            ArrayList<Pair<Integer, String>> currList = keyMap.get(key);
            int l = 0;
            int r = currList.size() - 1;
            String res = "";
            while(l <= r){
                int mid = (l + r) / 2;
                if(currList.get(mid).getKey() == timestamp)
                    return currList.get(mid).getValue();
                else if(currList.get(mid).getKey() > timestamp)
                    r = mid - 1;
                else{
                    res = currList.get(mid).getValue();
                    l = mid + 1;
                }
            }
            
            return res;
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