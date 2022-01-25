class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind equals = new UnionFind();
        
        for(String equ: equations){
            int first = equ.charAt(0) - 'a';
            int second = equ.charAt(3) - 'a';
            
            if(equ.charAt(1) == '=')
                equals.union(first, second);
        }
        
        for(String equ: equations){
            int first = equ.charAt(0) - 'a';
            int second = equ.charAt(3) - 'a';
            
            if(equ.charAt(1) == '!' && equals.isConnected(first, second))
                return false;
        }
        
        return true;
    }
    
    public class UnionFind{
        int[] parents;
        int[] ranks;
        
        public UnionFind(){
            parents = new int[26];
            ranks = new int[26];
            
            for(int i = 0 ; i < 26; i++){
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        public int find(int x){
            if(x == parents[x])
                return x;
            
            return parents[x] = find(parents[x]);
        }
        
        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX != parentY){
                if(ranks[parentX] < ranks[parentY]){
                    parents[parentX] = parentY;
                }
                else if(ranks[parentX] > ranks[parentY]){
                    parents[parentY] = parentX;
                }
                else{
                    parents[parentX] = parentY;
                    ranks[parentY]++;
                }
            }
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
        
        public ArrayList<Integer> allConnected(int x){
            ArrayList<Integer> res = new ArrayList();
            
            for(int i = 0; i < 26; i++){
                if(i != x && isConnected(x, i))
                    res.add(i);
            }
            
            return res;
        }
    }
}