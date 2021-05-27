class TicTacToe {
    int n;
    int[][] rowCount;
    int[][] colCount;
    int[][] diagCount;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rowCount = new int[n][2];
        colCount = new int[n][2];
        diagCount = new int[2][2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rowCount[row][player - 1]++;
        colCount[col][player - 1]++;
        if(row - col == 0)
            diagCount[0][player - 1]++;
        if(row + col == n - 1)
            diagCount[1][player - 1]++;
        
        if(rowCount[row][player - 1] == n || colCount[col][player - 1] == n
          || diagCount[0][player - 1] == n || diagCount[1][player - 1] == n)
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */