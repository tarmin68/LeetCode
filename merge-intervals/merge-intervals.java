class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        ArrayList<Pair<Integer, Integer>> res = new ArrayList();
        ArrayList<Pair<Integer, Integer>> mergables = new ArrayList();
        
        mergables.add(new Pair(intervals[0][0], intervals[0][1]));
        for(int i = 1; i < intervals.length; i++){
            if(isMergable(intervals[i], mergables)){
                mergables.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            else{
                res.add(merge(mergables));
                mergables = new ArrayList();
                mergables.add(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        
        res.add(merge(mergables));
        
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i).getKey();
            ans[i][1] = res.get(i).getValue();
        }
                   
        return ans;
    }
    
    public boolean isMergable(int[] first, ArrayList<Pair<Integer, Integer>> mergables){
        for(int i = 0; i < mergables.size(); i++){
            if((first[1] >= mergables.get(i).getKey() && first[1] <= mergables.get(i).getValue()) ||
              (first[0] >= mergables.get(i).getKey() && first[0] <= mergables.get(i).getValue()))
                return true;
        }
        return false;
    }
                   
    public Pair<Integer, Integer> merge(ArrayList<Pair<Integer, Integer>> mergables){
        int min = mergables.get(0).getKey();
        int max = mergables.get(0).getValue();
        
        for(int i = 0; i < mergables.size(); i++){
            min = Math.min(min, mergables.get(i).getKey());
            max = Math.max(max, mergables.get(i).getValue());
        }
        
        return new Pair(min, max);
    }           
}