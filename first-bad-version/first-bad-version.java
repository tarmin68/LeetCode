/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        
        while(l < h){
            int mid = (h - l) / 2 + l;
            if(isBadVersion(mid))
                h = mid;
            else
                l = mid + 1;
        }
        
        return l;
    }
}