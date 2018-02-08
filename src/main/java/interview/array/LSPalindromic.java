package interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/6.
 * LS means longest substring
 */
public class LSPalindromic {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome2("eabcdcbaG"));
//        System.out.println(longestPalindrome2("eeeabcddd"));
//        System.out.println(longestPalindrome2("babad"));
//        System.out.println(longestPalindrome2("cbbd"));
//        System.out.println(longestPalindrome2("a"));
//        System.out.println(longestPalindrome2("bb"));
        System.out.println(longestPalindrome2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public static String longestPalindrome(String s) {
        if(s==null || "".equals(s))
            return "";

        int max = 1;
        String maxStr = s.substring(0,1);

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <=i-1; j++) {
                String sub = s.substring(j,i);
                if(isPalindrome(sub.toCharArray())){
                    if(i-j>max){
                        max = i-j;
                        maxStr = sub;
                    }
                    break;
                }

            }
        }

        return maxStr;
    }

    public static boolean isPalindrome(char[] chars){
        int i=0,j=chars.length-1;
        while(i<j){
            if(chars[i++]!=chars[j--])return false;
        }
        return true;
    }

    public static String longestPalindrome2(String s) {
        if(s==null || "".equals(s))
            return "";

        int max = 1;
        String maxStr = s.substring(0,1);

        List<Integer> starts = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            List<Integer> newStarts = new ArrayList<>();

            for(int j=0;j<starts.size();j++){
                if(starts.get(j)>0){
                    if(s.charAt(starts.get(j)-1)==s.charAt(i)){
                        newStarts.add(starts.get(j)-1);
                    }
                }
            }

            starts = newStarts;

            if(i-2>=0 && s.charAt(i)==s.charAt(i-2)){
                starts.add(i-2);
            }

            if(s.charAt(i)==s.charAt(i-1)){
                starts.add(i-1);
            }

            for(int start:starts){
                if(i-start+1>max){
                    max = i-start+1;
                    maxStr = s.substring(start,i+1);
                }
            }
        }

        return maxStr;
    }
}
