class Solution {
    public int singleNumber(int[] nums) {

        /* Solution from Emirhan */

        /* We will use Xor operator ^  
        If you take xor of 2 same numbers, it will result zero.
        You will end up with only the different number. 
        */

        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer = answer ^ nums[i];
        }
        return answer;
    }
}