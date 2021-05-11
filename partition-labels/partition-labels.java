class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList();
        int start = 0;
        int end = 0;
        
        while(end < s.length()){
            for(int i = start; i <= end; i++){
                int nextEnd = s.lastIndexOf(s.charAt(i) + "");
                end = Math.max(end, nextEnd);
            }
            res.add(end - start + 1);
            start = end + 1;
            end = end + 1;
        }
        
        return res;
    }
}