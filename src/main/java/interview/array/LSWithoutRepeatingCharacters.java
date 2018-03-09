package interview.array;

import utils.Counter;

/**
 * Created by zly on 2018/2/6.
 * LS means longest substring
 * LSQ means longest subsequence
 */
public class LSWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Counter.count(()->{
            System.out.println(lengthOfLongestSubstring("c"));
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
            System.out.println(lengthOfLongestSubstring("bbbbb"));
            System.out.println(lengthOfLongestSubstring("pwwkew"));
            System.out.println(lengthOfLongestSubstring(""));
        });

        Counter.count(()->{
            System.out.println(lengthOfLongestSubstring2(""));
            System.out.println(lengthOfLongestSubstring2("abcabcbb"));
            System.out.println(lengthOfLongestSubstring2("bbbbb"));
            System.out.println(lengthOfLongestSubstring2("pwwkew"));
            System.out.println(lengthOfLongestSubstring2(""));
        });
    }

    public static int lengthOfLongestSubstring2(String s) {
        int lasts[] = new int[256],cur = 0,max = 0;
        for (int i = 0; i < s.length(); i++) {
            int ci = s.charAt(i);
            if(i>0 && lasts[ci]<i-cur+1){
                cur++;
            }else{
                cur = i-lasts[ci]+1;
            }
            lasts[ci] = i+1;
            max = Math.max(max,cur);
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || "".equals(s)) return 0;

        int max = 1,cur = 1,start=0;
        for (int i = 1; i < s.length(); i++) {
            int next = s.substring(start,i).indexOf(s.charAt(i)) + 1;
            if(next!=0){
                start += next;
                cur = i-start+1;
            }else{
                cur++;
            }
            max = Math.max(cur,max);
        }
        return max;
    }
}
