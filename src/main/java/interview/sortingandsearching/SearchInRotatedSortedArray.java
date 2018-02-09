package interview.sortingandsearching;

import utils.Printer;

/**
 * Created by zly on 2018/2/9.
 *
 * 注意没有重复
 *
 * 这里最简单的当然是先还原数组再二分查找，当然我直接使用二分查找
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Printer.print(search(new int[]{5,7,8,9,12,1},5));
        Printer.print(search(new int[]{5,7,8,9,12,1},1));
        Printer.print(search(new int[]{5,7,8,9,12,1},12));
        Printer.print(search(new int[]{0},1));
    }

    public static int search(int[] nums, int target) {
        if(nums.length==0)return -1;

        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1])
                min = i;
        }

        return binarySearch(nums,min,min,(min-1+nums.length)%nums.length,target);
    }

    public static int binarySearch(int[] nums,int offset, int start,int end,int target){
        if(nums[start]>target || nums[end]<target)
            return -1;

        if(nums[start]==target)
            return start;

        if(nums[end]==target)
            return end;

        int mid = (((start-offset+nums.length)%nums.length + (end-offset+nums.length)%nums.length)/2+offset)%nums.length;

        int left = binarySearch(nums,offset,start,mid,target);
        int right = binarySearch(nums,offset,(mid+1)%nums.length,end,target);

        if(left==-1 && right == -1){
            return -1;
        }else{
            return left!=-1?left:right;
        }
    }
}
