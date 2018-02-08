package interview.backtracking;


import utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zly on 2018/2/7.
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        Printer.print(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n<1){
            return res;
        }

        Stack<Boolean> stack = new Stack<>();

        backtrack(res,stack,new StringBuilder(),n,n);

        return res;
    }

    public static void backtrack(List<String> res, Stack<Boolean> stack,StringBuilder sb,int l,int r){
        if(l==0 && r==0){
            res.add(sb.toString());
        }

        if(stack.empty() || l>0){
            stack.push(true);
            sb.append("(");
            backtrack(res,stack,sb,l-1,r);

            stack.pop();
            sb.deleteCharAt(sb.length()-1);
        }

        if(!stack.empty() && r>0){
            stack.pop();
            sb.append(")");
            backtrack(res,stack,sb,l,r-1);

            stack.push(true);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
