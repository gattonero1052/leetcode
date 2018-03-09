package interview.backtracking;

import java.util.List;
import java.util.Stack;

/**
 * Created by zly on 2018/2/28.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        int errstart=0,errend=s.length()-1;

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==')'){
                if(s.length()>0)    stack.pop();
                else    break;
            }else
                stack.push(c);
            if(stack.isEmpty())
                errstart=i+1;
        }

        stack.empty();

        for (int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c==')'){
                if(s.length()>0)    stack.pop();
                else    break;
            }else
                stack.push(c);
            if(stack.empty())
                errend=i-1;
        }

        boolean outer = false;
        while(errstart<errend){
            if(s.charAt(errstart)=='(' && s.charAt(errend)==')'){
                errstart++;
                errend--;
                outer = true;
            }
        }

        if(outer){

        }else{

        }

        List<String> res = removeInvalidParentheses(s.substring(errstart,errend));
        return null;
    }
}
