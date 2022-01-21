class Solution {
    public int findMinDifference(List<String> timePoints) {
        int totalMins = 24 * 60;
        
        int[] allMins = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++){
            allMins[i] = getMin(timePoints.get(i));
        }
        
        int min = totalMins;
        for(int i = 0; i < allMins.length; i++){
            for(int j = i + 1; j < allMins.length; j++){
                min = Math.min(min, Math.abs(allMins[i] - allMins[j]));
                min = Math.min(min, Math.abs(allMins[i] + totalMins - allMins[j]));
                min = Math.min(min, Math.abs(allMins[i] - totalMins - allMins[j]));
            }
        }
        
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