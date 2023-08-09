import java.util.Arrays;

class Solution {
    public int reverse(int x) {
        
      int reversedNumber = 0;

      int minValue = Integer.MIN_VALUE;
      int maxValue = Integer.MAX_VALUE;

      while (x != 0){

        System.out.println("Hırr");

        //Taking last digit by modulo operation:
        int lastDigit = x % 10;

            //We check overflow cases, If new multiplication or last digit will cause overflow in both sizes
            //Positive or negative.         
        if (reversedNumber > maxValue / 10 || (reversedNumber == maxValue / 10 && lastDigit > 7) )
            return 0;
        
        if (reversedNumber < minValue / 10 || (reversedNumber == minValue / 10 && lastDigit < -8))
            return 0;

        reversedNumber = reversedNumber * 10 + lastDigit;

        x = x / 10;
      }
      return reversedNumber;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.reverse(123));


    }

}