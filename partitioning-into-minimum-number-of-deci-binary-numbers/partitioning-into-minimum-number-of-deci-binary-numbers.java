class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i = 0; i < n.length(); i++){
            max = Math.max(max, Integer.valueOf(n.charAt(i) + ""));
        }
        
        return max;
    }
}