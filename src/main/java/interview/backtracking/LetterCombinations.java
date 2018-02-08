package interview.backtracking;

import utils.Counter;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/7.
 * letterCombinations : not recursive backtrack
 * letterCombinations2 : recursive backtrack
 */
public class LetterCombinations {
    public static void main(String[] args) {
        Counter.count(()->{
            Printer.print(letterCombinations("6456545666886").size());
        });

        Counter.count(()->{
            Printer.print(letterCombinations2("6456545666886").size());
        });
    }

    public static List<String> letterCombinations2(String digits) {
        if("".equals(digits) || digits==null)
            return new ArrayList<>();

        String[] strs = new String[]{
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
        };
        List<String> using = new ArrayList<>();
        for(Character digit:digits.toCharArray()){
            using.add(strs[(digit-50)]);
        }
        List<String> res = new ArrayList<>();
        backtrack(using,0,res,new StringBuilder());
        return res;
    }

    public static void backtrack(List<String> using,int index,List<String> res,StringBuilder cur){
        if(index==using.size()){
//            res.add(cur.toString());
        }else{
            String curStr = using.get(index);
            for(int i=0;i<curStr.length();i++){
                cur.append(curStr.charAt(i));
                backtrack(using,index+1,res,cur);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if("".equals(digits) || digits==null)
            return new ArrayList<>();

        String[] strs = new String[]{
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
        };

        List<String> using = new ArrayList<>();
        for(Character digit:digits.toCharArray()){
            using.add(strs[(digit-50)]);
        }

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i=0,steps[] = new int[using.size()];
        while(true){

            if(i==steps.length){
//                res.add(sb.toString());

                //backtrack
                sb.deleteCharAt(sb.length()-1);
                i--;

                continue;
            }

            String cur = using.get(i);

            if(steps[i]==cur.length()){
                if(i==0){
                    //end
                    break;
                }else{
                    //backtrack
                    sb.deleteCharAt(sb.length()-1);
                    steps[i--] = 0;
                }
            }else{
                sb.append(cur.charAt(steps[i++]++));
            }
        }

        return res;
    }
}
