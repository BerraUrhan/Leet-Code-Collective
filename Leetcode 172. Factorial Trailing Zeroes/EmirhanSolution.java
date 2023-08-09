import java.util.*;

class Solution {
    public int trailingZeroes(int n) {
     
        /* Emirhan Solution */

        /* In order to have a traling zero, we must have a 10 multiplier, which is 2 * 5 
        Since already half of the number until n has at least one multiplier two (And some of them has more)
        We should count 5's. 
        */
        int counter = 0;

        for (int i = 5; i <= n; i *= 5){
            counter += n / i;
        }
        return counter;
    }
}