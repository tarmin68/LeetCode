class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        int[] diff = new int[length];
        
        for(int i = 0; i < updates.length; i++){
            diff[updates[i][0]] += updates[i][2];
            if(updates[i][1] + 1 < diff.length)
                diff[updates[i][1] + 1] -= updates[i][2];
        }
        
        arr[0] = diff[0];
        for(int i = 1; i < length; i++){
            arr[i] = arr[i - 1] + diff[i];
        }
        
        return arr;
    }
}