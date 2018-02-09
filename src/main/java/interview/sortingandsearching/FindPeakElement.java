package interview.sortingandsearching;

import utils.Printer;

/**
 * Created by zly on 2018/2/9.
 * 对数时间复杂度
 * 注意两点 1.递归的过程中，保持相同的前提条件，即两边都符合一半条件
 * 2.找中间点之前，排除掉下标溢出的情况（即首尾节点相同就不用找中间点了）
 */
public class FindPeakElement {
    public static void main(String[] args) {
        Printer.print(findPeakElement(new int[]{2,1}));
//        Printer.print(findPeakElement(new int[]{1, 2, 3, 1}));
//        Printer.print(findPeakElement(new int[]{1}));
//        Printer.print(findPeakElement(new int[]{1,2,1,2,1,2,1,2,1}));
//        Printer.print(findPeakElement(new int[]{1,2,1,2,1,2,1,2,1,2,1}));
//        Printer.print(findPeakElement(new int[]{4,3,2,1}));
//        Printer.print(findPeakElement(new int[]{1,2,3,4}));
//        Printer.print(findPeakElement(new int[]{1,2,3,2,1}));
//        Printer.print(findPeakElement(new int[]{3,2,1,2,3}));
//        Printer.print(findPeakElement(new int[]{1,6,5,4,3,2,1}));
    }

    public static int findPeakElement(int[] nums) {
        return findInRange(nums,0,nums.length-1);
    }

    public static int findInRange(int[] nums,int start,int end){
        if(start==end){
            return start;
        }

        boolean isStart = start==0 || nums[start-1]<nums[start],//起始位置是否比左边大
                isEnd = end==nums.length-1 || nums[end+1]<nums[end],//结束位置是否比右边大
        midLeft = nums[(start+end)/2]>nums[(start+end)/2+1];//中间位置左边是否比右边大

        if(isEnd && !midLeft){
            return findInRange(nums,(start+end)/2+1,end);
        }

        if(isStart && midLeft){
            return findInRange(nums,start,(start+end)/2);
        }

        if(nums[start]==nums[end]){
            if(midLeft)
                return findInRange(nums,start,(start+end)/2);
            else
                return findInRange(nums,(start+end)/2+1,end);
        }

        return  -1;
    }
}

