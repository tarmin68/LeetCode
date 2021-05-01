class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, (a, b) -> Integer.compare(a[1], b[1]));//sort in increasing order of size
        int res[] = new int[queries.length], i = 0;
        
        for(int q[] : queries){
            int idx = upperBound(rooms, q[1] - 1);//find the index for size greater then or equal to q[1]
            if(idx == -1){
                res[i++] = -1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = idx; j < rooms.length; j++)
                if(Math.abs(rooms[j][0] - q[0]) < min){//select with least abs value
                    res[i] = rooms[j][0];
                    min = Math.abs(rooms[j][0] - q[0]);
                } else if(Math.abs(rooms[j][0] - q[0]) == min)//when same abs value select least id
                    res[i] = Math.min(res[i], rooms[j][0]);

            i++;
        }
        return res;
    }
    
    private int upperBound(int[][] rooms, int k){
        int i = 0, j = rooms.length; 
        
        while(i < j){
            int mid = (i + j) / 2;
            
            if(rooms[mid][1] <= k)
                i = mid + 1;
            else 
                j = mid;
        }
        return i == rooms.length ? -1 : i;
    }
}