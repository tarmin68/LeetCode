public class Codec {
    HashMap<String, String> myMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash = getHash(longUrl);
        String shortUrl = getShortUrl(hash);
        myMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return myMap.get(shortUrl);
    }
    
    public int getHash(String longUrl){
        int p = 31;
        long m = 1000000007;
        
        long hash = 0;
        for(int i = 0; i < longUrl.length(); i++){
            hash = (long)(hash + (longUrl.charAt(i) - 'a') * Math.pow(p, i)) % m;
        }
        
        return (int) hash;
    }
    
    public String getShortUrl(int hash){
        String res = "";
        
        while(hash > 0){
            res = res + (hash % 26);
            hash = hash / 26;
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));