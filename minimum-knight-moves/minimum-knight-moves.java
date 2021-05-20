class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        
        boolean[][] isVisited = new boolean[605][605];
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        q.add(new Pair(0, 0));
        isVisited[302][302] = true;
    
        int move = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> currCell = q.poll();
                int currX = currCell.getKey();
                int currY = currCell.getValue();
                if(currX == x && currY == y)
                    return move;
                for(int j = 0; j < moves.length; j++){
                    if(!isVisited[currX + moves[j][0] + 302][currY + moves[j][1] + 302]){
                        q.add(new Pair(currX + moves[j][0], currY + moves[j][1]));
                        isVisited[currX + moves[j][0] + 302][currY + moves[j][1] + 302] = true;
                    }
                }
            }
            move++;
        }
        
        return -1;
    }
}