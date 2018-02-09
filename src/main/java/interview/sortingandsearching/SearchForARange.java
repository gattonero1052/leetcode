package interview.sortingandsearching;

import utils.Printer;

/**
 * Created by zly on 2018/2/9.
 * 对数时间复杂度
 */
public class SearchForARange {
    public static void main(String[] args) {
        Printer.print(searchRange(new int[]{1},0));
        Printer.print(searchRange(new int[]{5, 7, 7, 8, 8, 10},8));
        Printer.print(searchRange(new int[]{},8));
    }

    public static int[] searchRange(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    public static int[] search(int[] nums,int start,int end,int target){
        if(start>end || nums[start]>target || nums[end]<target) return new int[]{-1,-1};

        if(nums[start] == nums[end]){
            if(nums[start] == target)
                return new int[]{start,end};
            else
                return new int[]{-1,-1};
        }

        int[] left = search(nums,start,(start+end)/2,target),right = search(nums,(start+end)/2+1,end,target);

        int leftleft,rightright;

        if(left[0]!=-1)
            leftleft = left[0];
        else{
            if (right[0]!=-1)
                leftleft = right[0];
            else
                leftleft = -1;
        }

        if(right[1]!=-1)
            rightright = right[1];
        else{
            if(left[1]!=-1)
                rightright = left[1];
            else
                rightright = -1;
        }

        return new int[]{leftleft,rightright};
    }
}
