class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        Queue<Paren> q = new LinkedList();
        q.add(new Paren(1, 0, 1, "("));
        
        while(!q.isEmpty()){
            Paren curr = q.poll();
            if(curr.paren.length() == 2 * n)
                res.add(curr.paren);
            if(curr.status > 0){
                q.add(new Paren(curr.openNum, curr.closeNum + 1, curr.status - 1, curr.paren + ")"));
            }
            if(curr.openNum < n){
                q.add(new Paren(curr.openNum + 1, curr.closeNum, curr.status + 1, curr.paren + "("));
            }
        }
        
        return res;
    }
    
    public class Paren{
        int openNum;
        int closeNum;
        int status;
        String paren;
        
        Paren(int openNum, int closeNum, int status, String paren){
            this.openNum = openNum;
            this.closeNum = closeNum;
            this.status = status;
            this.paren = paren;
        }
    }
}