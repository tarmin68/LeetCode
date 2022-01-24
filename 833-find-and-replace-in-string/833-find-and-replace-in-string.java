class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        Item[] replaces = new Item[indices.length];
        for(int i = 0; i < indices.length; i++){
            replaces[i] = new Item(indices[i], sources[i], targets[i]);
        }
        
        Arrays.sort(replaces, (a, b) -> a.index - b.index);
        
        StringBuilder res = new StringBuilder();
        int idxDif = 0;
        
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(idx < replaces.length && replaces[idx].index == i){
                if(s.startsWith(replaces[idx].source, i)){
                    res.append(replaces[idx].target);
                    i += replaces[idx].source.length() - 1;
                    System.out.println(i);
                }
                else{
                    res.append(s.charAt(i));
                }
                idx++;
            }
            else{
                res.append(s.charAt(i));
            }
        }
        // for(int i = 0; i < replaces.length; i++){
        //     if(){
        //         int start = replaces[i].index + idxDif;
        //         int end = start + replaces[i].source.length();
        //         res.replace(start, end, replaces[i].target);
        //         idxDif += (replaces[i].target.length() - replaces[i].source.length());
        //     }
        // }
        
        return res.toString();
    }
    
    public class Item{
        int index;
        String source;
        String target;
        
        public Item(int index, String source, String target){
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
}