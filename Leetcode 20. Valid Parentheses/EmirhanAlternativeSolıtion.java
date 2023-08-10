import java.util.HashMap;
import java.util.Stack;

public class Solution {

    /*
    Alternative Solution (using HashMap)
    */

    public boolean isValid(String s) {

        HashMap<Character, Character> parantesis = new HashMap<>();

        parantesis.put('(', ')');
        parantesis.put('{', '}');
        parantesis.put('[', ']');

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++){

            char currentChar = s.charAt(i);

            if (parantesis.containsKey(currentChar))
                stack.add(currentChar);
            else {
                char top = stack.isEmpty() ? 'X' : stack.peek();

                if (currentChar == parantesis.getOrDefault(top, 'A')){
                    stack.pop();
                } else {
                    stack.add(currentChar);
                }
            }
        }

        return stack.isEmpty();
    }   
}
