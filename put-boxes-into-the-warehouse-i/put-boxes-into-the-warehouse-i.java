class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        PriorityQueue<Integer> boxesHeight = new PriorityQueue();
        for(int i = 0; i < boxes.length; i++){
            boxesHeight.add(boxes[i]);
        }
        PriorityQueue<Pair<Integer, Integer>> spaces = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> a.getKey() - b.getKey());
        for(int i = 0; i < warehouse.length; i++){
            spaces.add(new Pair(warehouse[i], i));
        }
        
        int count = 0;
        int availPos = warehouse.length - 1;
        while(availPos >= 0 && !boxesHeight.isEmpty() && !spaces.isEmpty()){
            // while(!spaces.isEmpty() && spaces.peek().idx > availPos){
            //     spaces.poll();
            // }
            int currBoxH = boxesHeight.poll();
            while(!spaces.isEmpty() && spaces.peek().getKey() < currBoxH){
                availPos = Math.min(availPos, spaces.poll().getValue() - 1);
            }
            if(availPos >= 0){
                count++;
                availPos--;
            }
            else
                break;
        }
        
        return count;
    }
    
}