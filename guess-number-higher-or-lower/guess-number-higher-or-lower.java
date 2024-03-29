/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int h = n;
        int mid = l + (h - l) / 2;
        int g = guess(mid);
        
        while(g != 0){
            if(g < 0){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
            mid = l + (h - l) / 2;
            g = guess(mid);
        }
        
        return mid;
    }
}