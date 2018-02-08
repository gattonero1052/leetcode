package interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/7.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        solution(res,new boolean[nums.length],new int[nums.length],0,nums);
        return res;
    }

    public static void solution(List<List<Integer>> list,boolean[] used,int[] current,int step,int[] nums){
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i] = true;
                current[step] = nums[i];
                if(step==nums.length-1){
                    //save
                    List<Integer> res = new ArrayList<>();
                    for(int k:current)
                        res.add(k);
                    list.add(res);
                }else{
                    solution(list,used,current,step+1,nums);
                }
                used[i] = false;
            }
        }
    }
}
