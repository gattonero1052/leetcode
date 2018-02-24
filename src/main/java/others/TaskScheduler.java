package others;

import utils.Printer;

import java.util.Arrays;

/**
 * Created by zly on 2018/2/24.
 *
 * 相当于求数组中最大值元素以及其个数吧
 * 如果看到元素是字符类型，那么需要想到能够用序号作为数组下标，这样可以快一点，同时也不会改变空间复杂度
 */
public class TaskScheduler {
    public static void main(String[] args) {
        Printer.print(leastInterval(new char[]{'A'},3));
        Printer.print(leastInterval(new char[]{'A','A','A','B','B','B'},2));
        Printer.print(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
    }
//    public int leastInterval(char[] tasks, int n) {
//        int list[] = new int[26], count = tasks.length, sum = 0;
//
//        for (char c : tasks)
//            list[c - 65]++;
//
//        Arrays.sort(list);
//
//        int i = 25;
//        while (i >= 0 && list[i] == list[25]) i--;
//
//        return Math.max(tasks.length, (n+1) * (list[25] - 1) + 25 - i);
//    }

    public static int leastInterval(char[] tasks, int n) {
        if(tasks.length==0)return 0;

        Arrays.sort(tasks);

        int max=1,cur=1,count=0;
        for (int i = 1; i < tasks.length; i++) {
            if(tasks[i] == tasks[i-1]){
                cur++;
                if(cur>max){
                    count=0;
                    max = cur;
                }

                if(i==tasks.length-1 && cur==max)
                    count++;
            }else{
                if(cur==max)
                    count++;

                cur = 1;
            }
        }

        return Math.max(tasks.length,count+(max-1)*(n+1));
    }
}
