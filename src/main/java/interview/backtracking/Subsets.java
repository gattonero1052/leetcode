package interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/7.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        return solution(nums,0);
    }

    public static List<List<Integer>> solution(int[] nums,int start){
        List<List<Integer>> lists;
        if(start==nums.length){
            lists = new ArrayList<>();
            List<Integer> list= new ArrayList<>();
            lists.add(list);
            return lists;
        }

        lists = solution(nums,start+1);
        int len = lists.size();
        for(int i=0;i<len;i++){
            List<Integer> list = new ArrayList<>();
            list.addAll(lists.get(i));
            list.add(nums[start]);
            lists.add(list);
        }
        return lists;
    }
}
