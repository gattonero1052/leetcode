package interview.sortingandsearching;

import utils.Printer;

import java.util.*;

/**
 * Created by zly on 2018/2/9.
 *
 * Onlogn
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        Printer.print(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i <nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            list.add(entry);
        }


        list.sort(Comparator.comparing(e->e.getValue()));

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(list.size()-1-i).getKey());
        }

        return res;
    }
}
