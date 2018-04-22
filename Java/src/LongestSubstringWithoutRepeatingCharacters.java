
public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		int longest = 0; // keeps length of longest substring 
		int currentLength = 0; // keeps length of current substring
		int[] chars = new int[128];	// keeps index of a character in current substring assuming 128 ASCII character
		for(int i = 0; i < s.length(); i++){
			if(chars[s.charAt(i)] == 0){	// If current substring does not contain this character 
				chars[s.charAt(i)] = i + 1;
				currentLength++;
				if(currentLength > longest){
					longest = currentLength;
				}
			}
			else{
				currentLength = 0;
				i = chars[s.charAt(i)] - 1;
				chars = new int[128];
			}
		}

		return longest;
	}
}
