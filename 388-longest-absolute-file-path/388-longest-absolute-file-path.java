class Solution {
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> dirLength = new HashMap();
        dirLength.put(0,-1);
        
        String[] parts = input.split("\n");
        
        int maxLength = 0;
        for(int i = 0; i < parts.length; i++){
            String[] pathParts = parts[i].split("\t");
            int currLength = dirLength.get(pathParts.length - 1);
            currLength += 1 + pathParts[pathParts.length - 1].length();
            if(pathParts[pathParts.length - 1].contains("."))
                maxLength = Math.max(maxLength, currLength);
            else
                dirLength.put(pathParts.length, currLength);
        }
        
        return maxLength;
    }
}