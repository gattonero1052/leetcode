package interview.sortingandsearching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly on 2018/2/9.
 */
public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();

        for(Interval interval:intervals){
            //遍历并去除
            int start = interval.start;
            int end = interval.end;
            List<Interval> removes = new ArrayList<>();
            for(int i=0;i<res.size();i++){
                Interval cur = res.get(i);
                if(interval.start<=cur.end&&interval.end>=cur.start){
                    start = Math.min(cur.start,start);
                    end = Math.max(cur.end,end);
                    removes.add(cur);
                }
            }

            for(Interval remove:removes){
                res.remove(remove);
            }

            //合并
            res.add(new Interval(start,end));
        }

        return res;
    }
}
