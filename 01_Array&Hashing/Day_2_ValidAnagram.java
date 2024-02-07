/**
 * Day_2_ValidAnagram
 */
public class Day_2_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int store[] = new int[26]; // there are 26 letters in alphabet

        // adding 1 each time we got the character
        // if we subtract the 'a' with any other alphabet we get the position
        for(int i=0; i<s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for(int value : store) {
            if(value != 0) return false;
        }
        return true;
    }
}

/*
 * Time complexity : O(N)
 * 
 * Space complexity : O(N)
 */