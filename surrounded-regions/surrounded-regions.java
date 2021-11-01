class Solution {
    boolean[][] visited;
    int m;
    int n;
    
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && board[i][j] == 'O')
                    captureRegions(board, i, j);
            }
        }
    }
    
    public void captureRegions(char[][] board, int r, int c){
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        Set<Pair<Integer, Integer>> s = new HashSet();
        boolean isCaptured = true;
        
        q.add(new Pair<Integer, Integer>(r, c));
        while(!q.isEmpty()){
            Pair<Integer, Integer> currPair = q.poll();
            int row = currPair.getKey();
            int col = currPair.getValue();
            if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O' || visited[row][col])
                continue;
            if(row == 0 || row == m - 1 || col == 0 || col == n - 1){
                isCaptured = false;
            }
            else{
                s.add(new Pair(row, col));
            }
            visited[row][col] = true;
            q.add(new Pair(row + 1, col));
            q.add(new Pair(row - 1, col));
            q.add(new Pair(row, col + 1));
            q.add(new Pair(row, col - 1));
        }
        
        if(isCaptured){
            for(Pair<Integer, Integer> curr : s){
                int row = curr.getKey();
                int col = curr.getValue();
                board[row][col] = 'X';
            }
        }
    }
}