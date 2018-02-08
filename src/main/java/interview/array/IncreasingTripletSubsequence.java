package interview.array;

/**
 * Created by zly on 2018/2/6.
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet(new int[]{1,0,0,10,0,0,100}));
        System.out.println(increasingTriplet(new int[]{2,5,3,4,5}));
        System.out.println(increasingTriplet(new int[]{1,8,5,2,3}));
    }

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;

        int second = Integer.MAX_VALUE,pre = nums[1],min = Math.min(nums[0],nums[1]);

        if(nums[0]<nums[1])
            second = nums[1];

        for (int i = 2; i <nums.length ; i++) {
            if(nums[i]>pre){
                if(nums[i]>second)
                    return true;
            }

            if(nums[i]>min)
                second = nums[i];

            min = Math.min(min,nums[i]);
            pre = nums[i];
        }

        return false;
    }
}
