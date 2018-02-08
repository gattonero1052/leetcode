package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zly on 2018/2/5.
 */
public class Printer {
    //pring int
    public static void print(int obj){
        System.out.println(obj);
    }

    //print int array
    public static void print(int[][] arrs){
        Arrays.asList(arrs).forEach(Printer::print);
    }

    //convert to string and using stream API
    public static void print(int[] arr){
        System.out.println(Arrays.stream(arr).parallel()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    //print collection
    public static void print(List objs){
        if(objs!=null && objs.size()>0){
            if(objs.get(0) instanceof List){
                for(Object obj:objs)
                    print((List<Object>)obj);
            }else{
                System.out.println(objs.parallelStream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
            }
        }
    }

    //方便切换是否打印输出
    public static void print(boolean t,Object obj){

    }
}
