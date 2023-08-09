import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        
        /* Emirhan Solution (Dynamic Programming) */
        
        //We are using Dynamic Programming Approach for solution:

        /*In a 2d array, we can keep information of each substring, 
         if it is a polindrom or not. Row id will be start index and column id will be
         end index. 
         -> For example if dpArray[1][4] = 4 that means the substing between the 
         indexes 1 and 4 is polindrom of size 4. 
         -> If dpArray[3][4] = 0 this means it is not a polindrom. 

         For every substring, we will check if its last and first chars are equal and if 
         the remaing part of it create a polindrom. 
        */

        int N = s.length();
        int answerStartIndex = 0;
        int maxLength = 1;

        int[][] dpArray = new int[N][N];

        //Every character is a polindrom itself, of size 1. 
        for (int i = 0; i < N; i++) dpArray[i][i] = 1;

        //We will also calculate couples:
        for (int startIndex = 0; startIndex < N - 1; startIndex++)
        {
            if (s.charAt(startIndex) == s.charAt(startIndex+1))
            {
                dpArray[startIndex][startIndex+1] = 2;
                answerStartIndex = startIndex;
                maxLength = 2;
            }
        }


        /*
        Now using the calculated size 1 and size 2 polindroms, we can compute other polindroms:
        We will compute polindromes of each size, 3, 4, . . .  N respectively.
        We will create a loop variable called difference. for a substring of s[0] to s[2] (including s[2]) difference of start and end indexes will be 2.
        Actually we are filling dpArray dialonally here. 
        */

        for (int difference = 2; difference < N; difference++)
        {
            /*
            We will compute [0,2], [1,3], [2,4] ...
            [0, 3], [1, 4] ... respectively.
            As you notice, difference is equal to our end index in the first iteration.
            */
            for (int endIndex = difference; endIndex < N; endIndex++)
            {
                int startIndex = endIndex - difference;

                if (s.charAt(startIndex) == s.charAt(endIndex) //If first and last chars are equal in this substring
                    &&
                    dpArray[startIndex+1][endIndex-1] != 0 //And excluding first and last chars If we still do have a polindrome that means this substring is also a polindrome.
                ){
                    dpArray[startIndex][endIndex] = dpArray[startIndex+1][endIndex-1] + 2;
                    answerStartIndex = startIndex;
                    maxLength = dpArray[startIndex][endIndex];
                }


            }
        }

        return s.substring(answerStartIndex, answerStartIndex + maxLength);

    }
}