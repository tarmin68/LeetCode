class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        
        int i = 0;
        int j = 0;
        while(i < revisions1.length || j < revisions2.length){
            int x = 0;
            int y = 0;
            
            if(i <  revisions1.length){
                x = Integer.valueOf(revisions1[i++]);
            }
            if(j <  revisions2.length){
                y = Integer.valueOf(revisions2[j++]);
            }
            
            if(x < y)
                return -1;
            if(x > y)
                return 1;
        }
        
        return 0;
    }
}