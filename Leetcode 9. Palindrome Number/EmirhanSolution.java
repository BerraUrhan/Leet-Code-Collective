class Solution {
    public boolean isPalindrome(int x) {
       
        /* Solution from Emirhan:
        We will reverse the number and check if reversed number still equals x. */

        long originalNumber = x;
        long reversed = 0;

        /* For decimals multiplying a number with is actully left shifting the number. 
        And the same way, integer division by 10 is right shifting. */

        while (x > 0){
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }

        return originalNumber == reversed;
        


    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.isPalindrome(1000021));
    }

}