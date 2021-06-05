class Solution {
    Set<ArrayList<Integer>> forbidden = new HashSet();
    boolean[][][][] isVisited = new boolean[10][10][10][10];
        
    public int openLock(String[] deadends, String target) {
        getDeadends(deadends);
        ArrayList<Integer> targetArr = new ArrayList();
        targetArr.add(target.charAt(0) - '0');
        targetArr.add(target.charAt(1) - '0');
        targetArr.add(target.charAt(2) - '0');
        targetArr.add(target.charAt(3) - '0');
        
        PriorityQueue<Pair<ArrayList<Integer>, Integer>> q = new PriorityQueue<Pair<ArrayList<Integer>, Integer>>((a,b) -> a.getValue() - b.getValue());
        q.add(new Pair(new ArrayList(List.of(0,0,0,0)), 0));
        isVisited[0][0][0][0] = true;
        
        while(!q.isEmpty()){
            Pair<ArrayList<Integer>, Integer> currStatus = q.poll();
            ArrayList<Integer> currNum = currStatus.getKey();
            int currMove = currStatus.getValue();
            
            if(forbidden.contains(currNum))
                continue;
            
            if(currNum.equals(targetArr))
                return currMove;
            
            if(!isVisited[(currNum.get(0) + 1) % 10][currNum.get(1)][currNum.get(2)][currNum.get(3)]){
                q.add(new Pair(new ArrayList(List.of((currNum.get(0) + 1) % 10, currNum.get(1), currNum.get(2), currNum.get(3))), currMove + 1));
                isVisited[(currNum.get(0) + 1) % 10][currNum.get(1)][currNum.get(2)][currNum.get(3)] = true;
            }
            if(!isVisited[(currNum.get(0) + 9) % 10][currNum.get(1)][currNum.get(2)][currNum.get(3)]){
                q.add(new Pair(new ArrayList(List.of((currNum.get(0) + 9) % 10, currNum.get(1), currNum.get(2), currNum.get(3))), currMove + 1));
                isVisited[(currNum.get(0) + 9) % 10][currNum.get(1)][currNum.get(2)][currNum.get(3)] = true;
            }
            
            if(!isVisited[currNum.get(0)][(currNum.get(1) + 1) % 10][currNum.get(2)][currNum.get(3)]){
                q.add(new Pair(new ArrayList(List.of(currNum.get(0), (currNum.get(1) + 1) % 10, currNum.get(2), currNum.get(3))), currMove + 1));
                isVisited[currNum.get(0)][(currNum.get(1) + 1) % 10][currNum.get(2)][currNum.get(3)] = true;
            }
            if(!isVisited[currNum.get(0)][(currNum.get(1) + 9) % 10][currNum.get(2)][currNum.get(3)]){
                q.add(new Pair(new ArrayList(List.of(currNum.get(0), (currNum.get(1) + 9) % 10, currNum.get(2), currNum.get(3))), currMove + 1));
                isVisited[currNum.get(0)][(currNum.get(1) + 9) % 10][currNum.get(2)][currNum.get(3)] = true;
            }
            
            if(!isVisited[currNum.get(0)][currNum.get(1)][(currNum.get(2) + 1) % 10][currNum.get(3)]){
                q.add(new Pair(new ArrayList(List.of(currNum.get(0), currNum.get(1), (currNum.get(2) + 1) % 10, currNum.get(3))), currMove + 1));
                isVisited[currNum.get(0)][currNum.get(1)][(currNum.get(2) + 1) % 10][currNum.get(3)] = true;
            }
            if(!isVisited[currNum.get(0)][currNum.get(1)][(currNum.get(2) + 9) % 10][currNum.get(3)]){
                q.add(new Pair(new ArrayList(List.of(currNum.get(0), currNum.get(1), (currNum.get(2) + 9) % 10, currNum.get(3))), currMove + 1));
                isVisited[currNum.get(0)][currNum.get(1)][(currNum.get(2) + 9) % 10][currNum.get(3)] = true;
            }
            
            if(!isVisited[currNum.get(0)][currNum.get(1)][currNum.get(2)][(currNum.get(3) + 1) % 10]){
                q.add(new Pair(new ArrayList(List.of(currNum.get(0), currNum.get(1), currNum.get(2), (currNum.get(3) + 1) % 10)), currMove + 1));
                isVisited[currNum.get(0)][currNum.get(1)][currNum.get(2)][(currNum.get(3) + 1) % 10] = true;
            }
            if(!isVisited[currNum.get(0)][currNum.get(1)][currNum.get(2)][(currNum.get(3) + 9) % 10]){
                q.add(new Pair(new ArrayList(List.of(currNum.get(0), currNum.get(1), currNum.get(2), (currNum.get(3) + 9) % 10)), currMove + 1));
                isVisited[currNum.get(0)][currNum.get(1)][currNum.get(2)][(currNum.get(3) + 9) % 10] = true;
            }
        }
        
        return -1;
    }
    
    public void getDeadends(String[] deadends){
        for(int i = 0; i < deadends.length; i++){
            ArrayList<Integer> dead = new ArrayList();
            dead.add(deadends[i].charAt(0) - '0');
            dead.add(deadends[i].charAt(1) - '0');
            dead.add(deadends[i].charAt(2) - '0');
            dead.add(deadends[i].charAt(3) - '0');
            forbidden.add(dead);
        }
    }
}