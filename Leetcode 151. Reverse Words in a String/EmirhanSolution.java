import java.util.*;

class Solution {
    public String reverseWords(String s) {
        
        /* Two Pointer's Solution from Emirhan */

        int leftPointer = 0, rightPointer = 0;

        List<String> words = new LinkedList<>();
        while (rightPointer < s.length() || leftPointer < s.length()){

            //Skipping whitespaces at the begining, left pointer will keep start of word.
            while (leftPointer < s.length() && s.charAt(leftPointer) == ' ')
                leftPointer++;
            
            rightPointer = leftPointer;

            //Rightpointer will go until next whitespace, 1 more index after end of string.
            while (rightPointer < s.length() && s.charAt(rightPointer) != ' ')
                rightPointer++;

            //This if block will work if we have a white space ending.
            if (leftPointer == rightPointer)
                break;

            String word = s.substring(leftPointer, rightPointer);
            words.add(word);

            //Starting to look for next string:
            leftPointer = rightPointer + 1;
        }

        Collections.reverse(words);
    
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));

        for (int i = 1; i < words.size(); i++){
            sb.append(" " + words.get(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Solution sol = new Solution();

        String answer = sol.reverseWords("  hello world  ");
        System.out.println("Answer: " + answer);

    }
}