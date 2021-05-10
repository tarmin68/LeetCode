class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> domCounts = new HashMap();
        
        for(int i = 0; i < cpdomains.length; i++){
            String[] parts = cpdomains[i].split(" ");
            int count = Integer.valueOf(parts[0]);
            String[] domains = parts[1].split("\\.");
            String currDomain = "";
            for(int j = domains.length - 1; j >= 0; j--){
                currDomain = domains[j] + currDomain;
                domCounts.put(currDomain, domCounts.getOrDefault(currDomain, 0) + count);
                currDomain = "." + currDomain;
            }
        }
        
        List<String> res = new ArrayList();
        for(String domain: domCounts.keySet()){
            res.add(domCounts.get(domain) + " " + domain);
        }
        
        return res;
    }
}