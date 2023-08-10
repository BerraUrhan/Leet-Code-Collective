import java.util.*;

class Solution {

    /* Solution From Emirhan */

    /*
        In this solution, we will use backtracking - dfs algorithm. 

        Let's put this problem in this way: If you have n pair of paranthesis,
        you should organize 5 open '(' and  5 close ')' paranthesis in a proper way.
        So at start we have 5 open and 5 paranthesis, we will build our paranthesis-strings
        using them until we reach 0 remaining left and right paranthesis.

        We will use StringBuilder class from Java. It is more efficient compare to String class 
        since it is mutable.
    */

    public List<String> generateParenthesis(int n) {

        List<String> answer = new LinkedList<>();
        dfs(n, n, new StringBuilder(), answer);
        return answer;

    }

    private void dfs(int leftParCount, int rightParCount, StringBuilder sb, List<String> answer){

        //If we used all left and right paranthesis, we completed the paranthesis string:
        if (leftParCount == 0 && rightParCount == 0){
            answer.add(sb.toString());
            return;
        }

        //If we still have left paranthesis, we can continute building a string using one of them. 
        if (leftParCount > 0){
            sb.append('(');
            dfs(leftParCount - 1, rightParCount, sb, answer);
            sb.deleteCharAt(sb.length() - 1);
        }

        //If we have more right paranthesis than left paranthesis, we have the rigth to add right par. to the string.
        if (rightParCount > leftParCount){
            sb.append(')');
            dfs(leftParCount, rightParCount - 1, sb, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}