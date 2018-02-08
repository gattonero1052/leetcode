package interview.design;


import utils.Printer;

import java.util.Arrays;

/**
 * Created by zly on 2018/2/5.
 */
public class ShuffleAnArray {
    public static void main(String[] args) {
        ShuffleAnArray obj = new ShuffleAnArray(new int[]{1,2,3});
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
        Printer.print(obj.shuffle());
    }


    private int[] original = null;
    public ShuffleAnArray(int[] nums) {
        original = Arrays.copyOf(nums,nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int size = original.length;
        boolean used[] = new boolean[size];
        int shuffle[] = new int[size],index = 0;
        for(int i=size;i>1;i--){
            int next = (int)Math.floor(i*Math.random());
            while(used[index] || next>0){
                if(!used[index]){
                    next--;
                }

                index = (index + 1)%size;
            }

            used[index] = true;
            shuffle[i-1] = original[index];
        }

        for(int i=0;i<used.length;i++)
            if(!used[i])
                shuffle[0] = original[i];

        return shuffle;
    }
}
