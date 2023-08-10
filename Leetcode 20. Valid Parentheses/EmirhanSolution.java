import java.util.*;

public class Solution {

    public boolean isValid(String s) {

        /* Emirhan Solution - using stack */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char currentPar = s.charAt(i);
            if (currentPar == '(' || currentPar == '[' || currentPar == '{'){
                //If we have right paranthesis, push to the stack and wait for its left complementor.
                stack.add(currentPar);
            } else {
                //We should check if stack is empty before gettin top element, due to cases like "]"
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if ((top == '(' && currentPar == ')') ||
                    (top == '[' && currentPar == ']') ||
                    (top == '{' && currentPar == '}')){
                        //This if block means we have reached end of a valid paranthesis.
                        stack.pop(); 
                } else 
                    return false;
            }
        }

        //If stack is empty at the end of the for loop, that means all paranthesis are closed properly
        //and we have a valid paranthesis combination.
        return stack.isEmpty();

    }   
}
