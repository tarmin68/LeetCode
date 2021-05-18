class Solution {
    int accountIdx = 0;
    HashMap<Integer, Set<String>> allAccounts = new HashMap();
    HashMap<Integer, String> accountName = new HashMap();
    HashMap<String, Integer> emailMap = new HashMap();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for(int i = 0; i < accounts.size(); i++){
            List<String> accountInfo = accounts.get(i);
            String name = accountInfo.get(0);
            int firstAccNum = getAccNum(accountInfo.get(1));
            accountName.put(firstAccNum, name);
            allAccounts.putIfAbsent(firstAccNum, new HashSet());
            allAccounts.get(firstAccNum).add(accountInfo.get(1));
            
            for(int j = 2; j < accountInfo.size(); j++){
                int currAccNum = getAccNum(accountInfo.get(j));
                if(allAccounts.get(currAccNum) == null){
                    allAccounts.get(firstAccNum).add(accountInfo.get(j));
                    emailMap.put(accountInfo.get(j), firstAccNum);
                }
                else{
                    Set<String> otherEmails = allAccounts.get(currAccNum);
                    for(String email : otherEmails){
                        allAccounts.get(firstAccNum).add(email);
                        emailMap.put(email, firstAccNum);
                    }
                    if(currAccNum != firstAccNum){
                        allAccounts.remove(currAccNum);
                    }
                }
            }
        }
        
        List<List<String>> res = new ArrayList();
        for(int accNum : allAccounts.keySet()){
            String name = accountName.get(accNum);
            Set<String> emails = allAccounts.get(accNum);
            List<String> account = new ArrayList(emails);
            Collections.sort(account);
            account.add(0, name);
            res.add(account);
        }
        
        return res;
    }
    
    public int getAccNum(String account){
        if(emailMap.get(account) != null)
            return emailMap.get(account);
        emailMap.put(account, accountIdx);
        return accountIdx++;
    }
}