class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int minX = m;
        int maxX = 0;
        int minY = n;
        int maxY = 0;
        
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        q.add(new Pair(x, y));
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currPair = q.remove();
            int r = currPair.getKey();
            int c = currPair.getValue();
            
            if(r < 0 || r >= m || c < 0 || c >= n || image[r][c] == '0' || isVisited[r][c])
                continue;
            
            minX = Math.min(minX, r);
            maxX = Math.max(maxX, r);
            minY = Math.min(minY, c);
            maxY = Math.max(maxY, c);
            
            q.add(new Pair(r - 1, c));
            q.add(new Pair(r + 1, c));
            q.add(new Pair(r, c - 1));
            q.add(new Pair(r, c + 1));
            
            isVisited[r][c] = true;
        }
        
        return (maxX - minX + 1)*(maxY - minY + 1);
    }    
}