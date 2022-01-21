class Solution {
    public int findMinDifference(List<String> timePoints) {
        int totalMins = 24 * 60;
        
        int[] allMins = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++){
            allMins[i] = getMin(timePoints.get(i));
        }
        
        Arrays.sort(allMins);
        int min = totalMins;
        for(int i = 0; i < allMins.length - 1; i++){
            min = Math.min(min, allMins[i + 1] - allMins[i]);
        }
        
        min = Math.min(min, allMins[0] + totalMins - allMins[allMins.length - 1]);
        return min;
    }
    
    public int getMin(String time){
        int min = 0;
        
        min += (time.charAt(0) - '0') * 10 * 60;
        min += (time.charAt(1) - '0') * 60;
        min += (time.charAt(3) - '0') * 10;
        min += (time.charAt(4) - '0');
        
        return min;
    }
}