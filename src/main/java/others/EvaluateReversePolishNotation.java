package others;

import utils.Printer;

import java.util.Stack;

/**
 * Created by zly on 2018/2/24.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Printer.print(evalRPN(new String[]{
                "18"
        }));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token:tokens){
            if("+-*/".indexOf(token)!=-1){

                if(token.equals("+")){
                    st.push(st.pop()+st.pop());
                }

                if(token.equals("-")){
                    st.push(-st.pop()+st.pop());
                }

                if(token.equals("*")){
                    st.push(st.pop()*st.pop());
                }
                if(token.equals("/")){
                    int p1 = st.pop();
                    int p2 = st.pop();
                    st.push(p2/p1);
                }
            }else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}
