package interview.array;

/**
 * Created by zly on 2018/2/6.
 * LS means longest substring
 * LSQ means longest subsequence
 */
public class LSWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("c"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
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
