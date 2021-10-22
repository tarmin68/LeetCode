class Solution {
    public String frequencySort(String s) {
        int[][] counts = new int[62][2];
        
        for(int i = 0; i < 62; i++){
            counts[i][0] = i;
        }
        
        for(int i = 0; i < s.length(); i++){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9')
                counts[s.charAt(i) - '0'][1]++;
            else if('a' <= s.charAt(i) && s.charAt(i) <= 'z')
                counts[s.charAt(i) - 'a' + 10][1]++;
            else
                counts[s.charAt(i) - 'A' + 36][1]++;
        }
        
        Arrays.sort(counts, (a, b) -> b[1] - a[1]);
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 62; i++){
            if(0 <= counts[i][0] && counts[i][0] <= 9){
                for(int j = 0; j < counts[i][1]; j++){
                    res.append((char)('0' + counts[i][0]));
                }
            }
            else if(10 <= counts[i][0] && counts[i][0] <= 35){
                for(int j = 0; j < counts[i][1]; j++){
                    res.append((char)('a' + counts[i][0] - 10));
                }
            }
            else{
                for(int j = 0; j < counts[i][1]; j++){
                    res.append((char)('A' + counts[i][0] - 36));
                }
            }
        }
        
        return res.toString();
    }
}