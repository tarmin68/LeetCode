 class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Pair<Integer,Integer>> mergables = new ArrayList();
        ArrayList<Pair<Integer, Integer>> result = new ArrayList();
        
        if(intervals.length == 0 || newInterval[1] < intervals[0][0]){
            result.add(new Pair(newInterval[0], newInterval[1]));
        }
        
        for(int i = 0; i < intervals.length; i++){
            if((intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1] ) || 
               (newInterval[0] <= intervals[i][0] && intervals[i][0] <= newInterval[1] )){
                mergables.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            else if(intervals[i][1] < newInterval[0] && i < intervals.length - 1 && newInterval[1] < intervals[i + 1][0]){
                result.add(new Pair(intervals[i][0], intervals[i][1]));
                result.add(new Pair(newInterval[0], newInterval[1]));
            }
            else{
                if(mergables.size() > 0){
                    result.add(merge(mergables, newInterval));
                    mergables = new ArrayList();
                }
                result.add(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        
        if(mergables.size() > 0){
            result.add(merge(mergables, newInterval));
        }
        
        if(intervals.length > 0 && newInterval[0] > intervals[intervals.length - 1][1]){
            result.add(new Pair(newInterval[0], newInterval[1]));
        }
        
        int[][] ans = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            ans[i][0] = result.get(i).getKey();
            ans[i][1] = result.get(i).getValue();
        }
        
        return ans;
    }
    
    public Pair<Integer, Integer> merge(ArrayList<Pair<Integer,Integer>> mergables, int[] newInterval){
        int min = newInterval[0];
        int max = newInterval[1];
        
        for(int i = 0; i < mergables.size(); i++){
            min = Math.min(min, mergables.get(i).getKey());
            max = Math.max(max, mergables.get(i).getValue());
        }
        
        return new Pair(min, max);
    }
}