public class Solution2 {
    public int reverse(int x){

        long reversed = 0;

        while (x != 0){
            int lastDigit = x % 10;
            reversed = 10 * reversed + lastDigit;
            x = x / 10;
        }

        if (reversed > Integer.MIN_VALUE && reversed < Integer.MAX_VALUE){
            return (int) reversed;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.reverse(-123));
    }

}
