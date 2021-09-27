class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidCol(board) && isValidBox(board);
    }
    
    public boolean isValidRow(char[][] board){
        for(int i = 0; i < 9; i++){
            Set<Integer> numSet = new HashSet();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(numSet.contains(num))
                        return false;
                    numSet.add(num);
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidCol(char[][] board){
        for(int j = 0; j < 9; j++){
            Set<Integer> numSet = new HashSet();
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(numSet.contains(num))
                        return false;
                    numSet.add(num);
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidBox(char[][] board){
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        for(int i = 1; i < 9; i += 3){
            for(int j = 1; j < 9; j += 3){
                Set<Integer> numSet = new HashSet();
                for(int k = 0; k < dir.length; k++){
                    if(board[i + dir[k][0]][j + dir[k][1]] != '.'){
                        int num = board[i + dir[k][0]][j + dir[k][1]];
                        if(numSet.contains(num))
                            return false;
                        numSet.add(num);
                    }
                }
            }
        }
        return true;
    }
}