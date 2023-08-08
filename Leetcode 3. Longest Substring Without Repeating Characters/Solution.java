import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s){
        
        /*
        Solution - 1 from Emirhan
        (HashSet Solution)
        */

        /* We keep letters in substrings in a HashSet.
        We choose HashSet daha structure because set's don't have duplicates
        and we can call set.contains(char) method in O(1) time complexity. */
        Set<Character> letters = new HashSet<>();
        
        //Start index of out substring.
        int start = 0;
        int answer = 0;

        //Index i actually keeps last index of our possible answer.
        for (int i = 0; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);
            //If we have a repeating char, we should shift our start index until we get rid of it. 
            if (letters.contains(currentChar)){
                while (!letters.contains(currentChar)){
                    letters.remove(s.charAt(start++));
                }
                letters.add(currentChar);
                
            } else {
                //If we don't have a repeating char, we can continute growing our string towards right.
                letters.add(currentChar);
            }
            //Updating our answer.
            answer = Math.max(answer, i - start + 1);
        }

        return answer;


    }
}
