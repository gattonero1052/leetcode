package interview.backtracking;

import utils.Counter;
import utils.Printer;

/**
 * Created by zly on 2018/2/28.
 */
public class WildcardMatching {
    public static void main(String[] args) {
        Counter.count(()->{
            Printer.print(isMatchFromDiscussion2("azeb","a*b*"));
        });
    }


    static boolean isMatch(String s, String p) {
        return btTLE(s,p.replaceAll("\\*+","*"));
    }

    //MY DP
    static boolean dp(String s,String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        /*
        if not *
        first = -1
        dp[j][i] = dp[j-1][i]?(match?true:false):false
        first = first==-1&&dp[j][i]?i:first
        else
        dp[j][i] = i<first?false:true
        */
        return dp[s.length()][p.length()];
    }

    //RECURSIVE
    static boolean btTLE(String s, String p) {
        if(p.isEmpty()){
            if(s.isEmpty()) return true;
            else return false;
        }

        char pattern = p.charAt(0);

        if(pattern=='*'){
//            if(p.length()>1&&p.charAt(1)!='?'&&s.charAt(0)!=p.charAt(1))
//                return bt(s.substring(1),p);
            return (!s.isEmpty()&& btTLE(s.substring(1),p)) || btTLE(s,p.substring(1));
        }else if(!s.isEmpty() && (pattern=='?'||s.charAt(0)==pattern)){
            return btTLE(s.substring(1),p.substring(1));
        }

        return false;
    }

    //DP
    public static boolean isMatchFromDiscussion(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                    match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }

    //ANOTHER DP
    static boolean isMatchFromDiscussion2(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
