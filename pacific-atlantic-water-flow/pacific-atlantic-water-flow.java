class Solution {
    boolean[][] reachPacific;
    boolean[][] reachAtlantic;
    int[][] heights;
    int n;
    int m;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<List<Integer>>();
        
        heights = matrix;
        n = matrix.length;
        m = matrix[0].length;
        reachPacific = new boolean[n][m];
        reachAtlantic = new boolean[n][m];
        
        Queue<Pair<Integer, Integer>> pacificQ = new LinkedList<>();
        Queue<Pair<Integer, Integer>> atlanticQ = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            pacificQ.add(new Pair(i, 0));
            atlanticQ.add(new Pair(i, m - 1));
        }
        
        for(int i = 0; i < m; i++){
            pacificQ.add(new Pair(0, i));
            atlanticQ.add(new Pair(n - 1, i));
        }
        
        bfs(pacificQ, reachPacific);
        bfs(atlanticQ, reachAtlantic);
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(reachPacific[i][j] && reachAtlantic[i][j])
                    res.add(List.of(i, j));
            }
        }
        
        return res;
    }
    
    public void bfs(Queue<Pair<Integer, Integer>> q, boolean[][] reachables){
        boolean[][] isVisited = new boolean[n][m];
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currCell = q.poll();
            int i = currCell.getKey();
            int j = currCell.getValue();
            reachables[i][j] = true;
            
            if(i > 0 && !isVisited[i - 1][j] && heights[i - 1][j] >= heights[i][j]){
                isVisited[i - 1][j] = true;
                q.add(new Pair(i - 1, j));
            }
            if(i < n - 1 && !isVisited[i + 1][j] && heights[i + 1][j] >= heights[i][j]){
                isVisited[i + 1][j] = true;
                q.add(new Pair(i + 1, j));
            }
            if(j > 0 && !isVisited[i][j - 1] && heights[i][j - 1] >= heights[i][j]){
                isVisited[i][j - 1] = true;
                q.add(new Pair(i, j - 1));
            }
            if(j < m - 1 && !isVisited[i][j + 1] && heights[i][j + 1] >= heights[i][j]){
                isVisited[i][j + 1] = true;
                q.add(new Pair(i, j + 1));
            }
        }
    }
}