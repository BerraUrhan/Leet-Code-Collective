class Solution {
    public double myPow(double x, int n) {

        /* Solution from Emirhan */

        double answer = 1;

        //We use long data type to avoid overflow. If you multiply INTEGER.MIN_VAL with -1 it will cause overflow
        //as an integer data type.
        long power = n;

       if (n < 0)
            power *= -1;

        while (power != 0){
            if (power % 2 == 0){
                //If power is a even number, we can get square of the base number.
                x = x * x;
                power =  power / 2;
            } else {
                answer = answer * x;
                power--;
            }
        }

        if (n < 0)
            return 1.0 / (double) answer;
        else 
            return answer;
    }
}