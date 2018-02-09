package utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zly on 2018/2/5.
 */
public class Printer {
    //print str
    public static void print(String string){
        System.out.println(string);
    }

    //print bool
    public static void print(boolean bool){
        System.out.println(bool);
    }

    //print int
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

    public static void printTree(Object root){

        int MAXHEIGHT = 10;
        int[] max = new int[MAXHEIGHT];
        List<String>[] levels = new ArrayList[MAXHEIGHT];
        Queue<Object> queue = new LinkedList<>();

        //init array
        max[0] = 1;
        for (int i = 0; i < MAXHEIGHT; i++) {
            levels[i] = new ArrayList<>();
            max[i] = i==0?max[i]:(max[i-1])*2;
        }

        //traverse parameters
        boolean overMaxHeight = false;
        int count = 1,level=0;

        if(root!=null){
            queue.add(root);
            levels[level].add(treeValue(root));
        }

        while(!queue.isEmpty()){
            Object cur = queue.poll();

            if(cur!=null){
                Object left = treeLeft(cur);
                Object right = treeRight(cur);
                levels[level+1].add(treeValue(left));
                levels[level+1].add(treeValue(right));
                queue.add(left);
                queue.add(right);
                count+=2;
            }

            if(count==max[level]){
                count=0;
                level++;

                if(level>MAXHEIGHT){
                    overMaxHeight = true;
                    break;
                }
            }
        }

        if(overMaxHeight){
            System.out.println("最大树高为"+MAXHEIGHT+"！");
        }else{

        }
    }

    private static String treeValue(Object node){return "";}
    private static Object treeLeft(Object node){return null;}
    private static Object treeRight(Object node){return null;}
}
