class LRUCache {
    int capacity;
    HashMap<Integer, Integer> cache;
    TreeMap<Integer, Integer> LRU;
    HashMap<Integer, Integer> times;
    int timeStamp;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        LRU = new TreeMap();
        times = new HashMap();
        timeStamp = 0;
    }
    
    public int get(int key) {
        if(cache.get(key) == null){
            return -1;
        }
        int res = cache.get(key);
        int prevTime = times.get(key);
        LRU.remove(prevTime);
        timeStamp++;
        LRU.put(timeStamp, key);
        times.put(key, timeStamp);
        return res;
    }
    
    public void put(int key, int value) {
        if(cache.get(key) == null){
            cache.put(key, value);
            timeStamp++;
            times.put(key, timeStamp);
            LRU.put(timeStamp, key);
            evict();
        }
        else{
            cache.put(key, value);
            int prevTime = times.get(key);
            LRU.remove(prevTime);
            timeStamp++;
            LRU.put(timeStamp, key);
            times.put(key, timeStamp);
        }
    }
    
    public void evict(){
        if(LRU.size() > capacity){
            int lru = LRU.firstKey();
            int key = LRU.get(lru);
            cache.remove(key);
            times.remove(key);
            LRU.remove(lru);
        }
    }
    
    public class Pair implements Comparable<Pair>{
        int key;
        int timeStamp;
        
        public Pair(int key, int timeStamp){
            this.key = key;
            this.timeStamp = timeStamp;
        }
        
        @Override
        public int compareTo(Pair p){
            return Integer.compare(this.timeStamp, p.timeStamp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */