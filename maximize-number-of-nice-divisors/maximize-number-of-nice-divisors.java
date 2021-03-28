class Solution {
    long mod = 1000000007;
    
    public int maxNiceDivisors(int primeFactors) {
        if(primeFactors == 1)
            return 1;
        
        long res = 1;
        
        long m = primeFactors / 3;
        long r = primeFactors % 3;
        if(r == 1){
            m--;
            r += 3;
        }
        
        res = power3(m);
        if(r != 0) 
            res = (res * r) % mod;
        
        return (int) res;
    }
    
    public long power3(long m){
        if(m == 0)
            return 1;
        long ans = power3(m/2);
        
        if(m % 2 == 0)
            return (ans * ans) % mod;
        
        return (ans * ans * 3) % mod;
    }
}