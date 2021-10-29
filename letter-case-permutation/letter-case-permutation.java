class Solution {
    List<String> res = new ArrayList();
    
    public List<String> letterCasePermutation(String S) {
        permute(S, 0, "");
        return res;
    }
    
    public void permute(String S, int idx, String curr){
        if(idx >= S.length()){
            res.add(curr);
            return;
        }
        
        if('a' <= S.charAt(idx) && S.charAt(idx) <= 'z'){
            String newPerm = curr + S.charAt(idx);
            permute(S, idx + 1, newPerm);
            String newPerm2 = curr + (char)(S.charAt(idx) - 'a' + 'A');
            permute(S, idx + 1, newPerm2);
        }
        else if('A' <= S.charAt(idx) && S.charAt(idx) <= 'Z'){
            String newPerm = curr + S.charAt(idx);
            permute(S, idx + 1, newPerm);
            String newPerm2 = curr + (char)(S.charAt(idx) + 'a' - 'A');
            permute(S, idx + 1, newPerm2);
        }
        else{
            String newPerm = curr + S.charAt(idx);
            permute(S, idx + 1, newPerm);
        }
    }
}