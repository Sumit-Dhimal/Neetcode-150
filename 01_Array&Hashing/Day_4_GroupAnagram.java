import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day_4_GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            int count[] = new int[26]; // 26 alphabet 

            for(char c : s.toCharArray()) {
                count[c - 'a']++; // which char is present that's value will be increased
            }
            
            // convert char to StringBuilder
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++) {
                sb.append('#'); // it's optional
                sb.append(count[i]); // 
            }

            //convert StringBuilder to String
            String key = sb.toString();
            //System.out.println(key);

            // if the map doesn't contains key add key
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // after adding the key add list<String> values
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values()); // returns ArrayList<ArrayList<String>>
    }

    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(strs);

        for(List<String> a : ans) {
            System.out.println(a);
        }
    }
}

/*
 * Time complexity : O(M*N*26) i.e = O(M*N)
 *      Where N is the length on the given string
 *      M is the longest string
 *      26 is the size of the alphabet array
 * 
 * Space complexity : O(N)
 */