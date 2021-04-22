class Solution {
    public int missingNumber(int[] arr) {
        int min = Math.abs(arr[1] - arr[0]);
        for(int i = 2; i < arr.length; i++){
            min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(Math.abs(arr[i + 1] - arr[i]) != min)
                return (arr[i] + arr[i + 1]) / 2;
        }
        
        return arr[0];
    }
}