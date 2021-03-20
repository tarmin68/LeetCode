class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> customerMap;
    HashMap<Pair<String, String>, Double> avgMap;
    HashMap<Pair<String, String>, Integer> countMap;

    public UndergroundSystem() {
        customerMap = new HashMap<>();
        avgMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customerMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = customerMap.get(id);
        String startStation = checkIn.getKey();
        int startTime = checkIn.getValue();
        double prevAvg = avgMap.getOrDefault(new Pair(startStation, stationName), 0.0);
        int prevCount = countMap.getOrDefault(new Pair(startStation, stationName), 0);
        double newAvg = ((prevAvg * prevCount) + (t - startTime)) / (prevCount + 1);
        avgMap.put(new Pair(startStation, stationName), newAvg);
        countMap.put(new Pair(startStation, stationName), prevCount + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return avgMap.get(new Pair(startStation, endStation));
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */