class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edges = new HashMap();
        
        int start;
        int end;
        for(int i = 0; i < wall.size(); i++){
            start = 0;
            for(int j = 0; j < wall.get(i).size() - 1; j++){
                end = start + wall.get(i).get(j);
                edges.put(end, edges.getOrDefault(end, 0) + 1);
                start = end;
            }
        }
        
        int max = 0;
        for(Integer edge: edges.keySet()){
            max = Math.max(max, edges.get(edge));
        }
        
        return wall.size() - max;
    }
}