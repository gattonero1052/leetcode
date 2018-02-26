package interview.backtracking;

import utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/26.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Printer.print(isMatch("aa","a"));
        Printer.print(isMatch("aa","aa"));
        Printer.print(isMatch("aaa","aa"));
        Printer.print(isMatch("aa","a*"));
        Printer.print(isMatch("aa",".*"));
        Printer.print(isMatch("ab",".*"));
        Printer.print(isMatch("aab","c*a*b"));
        Printer.print(isMatch("aabbcc","c*a*b*ab*c*a*b*"));
        Printer.print(isMatch("ab",".*c"));
        Printer.print(isMatch("a",".*..a*"));
    }

    public static boolean isMatch(String s, String p) {
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c=='.'||(c>96&&c<123)){
                if(i<p.length()-1 && p.charAt(i+1)=='*'){
                    patterns.add(p.substring(i,i+2));
                }else{
                    patterns.add(p.substring(i,i+1));
                }
            }
        }

        return bt(patterns,0,0,s);
    }

    public static boolean bt(List<String> patterns,int matching,int cur,String s){
        if(matching==patterns.size()) {
            if (cur >= s.length())
                return true;
            else
                return false;
        }

        String pattern = patterns.get(matching);
        char matcher = pattern.charAt(0);
        boolean matchAll = pattern.length()==2;

        if(cur>=s.length() && !matchAll)
            return false;

        if(matcher=='.'){
            if(matchAll){

                //贪心匹配
                for (int i = s.length(); i >=cur ; i--) {
                    if(bt(patterns,matching+1,i,s))
                        return true;
                }
            }
            else
                return bt(patterns,matching+1,cur+1,s);
        }else{
            if(matchAll){
                int start = cur;
                while(cur<s.length() && s.charAt(cur)==matcher){cur++;}

                //贪心匹配
                for (int i = cur; i >=start ; i--) {
                    if(bt(patterns,matching+1,i,s))
                        return true;
                }

            }else if(s.charAt(cur)==matcher)
                return bt(patterns,matching+1,cur+1,s);
        }
        return false;
    }
}
