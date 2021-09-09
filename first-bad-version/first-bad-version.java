/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        int res = 1;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            if(isBadVersion(mid) == false){
                low = mid + 1;
            }
            else{
                res = mid;
                high = mid - 1;
            }
        }
        
        return res;
    }
}