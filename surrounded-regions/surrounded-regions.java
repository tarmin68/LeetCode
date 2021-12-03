class Solution {
    char[][] board;
    int m;
    int n;
    
    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O')
                checkOs(0, i);
            if(board[m - 1][i] == 'O')
                checkOs(m - 1, i);
        }
        
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')
                checkOs(i, 0);
            if(board[i][n - 1] == 'O')
                checkOs(i, n - 1);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'N')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void checkOs(int r, int c){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{r, c});
        board[r][c] = 'N';
        
        while(!q.isEmpty()){
            int[] currCell = q.remove();
            int currR = currCell[0];
            int currC = currCell[1];
            
            if(currR > 0 && board[currR - 1][currC] == 'O'){
                q.add(new int[]{currR - 1, currC});
                board[currR - 1][currC] = 'N';
            }
            if(currR < m - 1 && board[currR + 1][currC] == 'O'){
                q.add(new int[]{currR + 1, currC});
                board[currR + 1][currC] = 'N';
            }
            if(currC > 0 && board[currR][currC - 1] == 'O'){
                q.add(new int[]{currR, currC - 1});
                board[currR][currC - 1] = 'N';
            }
            if(currC < n - 1 && board[currR][currC + 1] == 'O'){
                q.add(new int[]{currR, currC + 1});
                board[currR][currC + 1] = 'N';
            }
        }
    }
}