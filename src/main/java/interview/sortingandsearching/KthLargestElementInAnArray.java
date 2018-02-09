package interview.sortingandsearching;

import java.util.Arrays;

/**
 * Created by zly on 2018/2/9.
 * 这什么jb题目，黑人问号.jpg
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
