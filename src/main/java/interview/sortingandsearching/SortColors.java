package interview.sortingandsearching;

import utils.Printer;

/**
 * Created by zly on 2018/2/9.
 *
 * 有一个使用On空间复杂度，两次遍历的简单方法
 *
 * 这里题目要求用O1的空间复杂度，并且一次遍历
 *
 * 下标的选择要特别注意，最好不要把自加和自减写进判断条件里，不然逻辑会比较乱
 */
public class SortColors {
    public static void main(String[] args) {
        int[] res = new int[]{0,1,0,1,0,2,0,1,2,2,2,2,0,0,0,1,1,1,2,1,0};
        sortColors(res);
        Printer.print(res);
    }

    public static void sortColors(int[] nums) {
        if(nums.length>1){
            int redend = 0,bluestart = nums.length-1;

            //get start,end
            while(redend<nums.length && nums[redend]==0){redend++;}
            while(bluestart>=0 && nums[bluestart]==2){bluestart--;}

            for (int i = redend; i <= bluestart;) {
                if(nums[i]==1){
                    i++;
                }else if(nums[i]==0){
                    swap(nums,redend++,i++);
                }else{
                    swap(nums,bluestart--,i);
                }
            }
        }
    }

    public static void swap(int[] n,int a,int b){
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }
}
