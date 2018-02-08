package interview.array;


import utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zly on 2018/2/6.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Printer.print(groupAnagrams(new String[]{"","","eat", "tea", "tan", "ate", "nat", "bat"}));
//        Printer.print(groupAnagrams(new String[]{""}));
    }


    private static class Node{
        Node(Character c){
            this.c = c;
        }

        Character c = null;
        List<Node> children = null;
        List<String> strs = new ArrayList<>();
    }

    private static Node add(Node node,Character c){
        Node next = null;
        if(node.children==null) {
            node.children = new ArrayList<>();
            next = new Node(c);
            node.children.add(next);
        }else{
            for(Node child:node.children){
                if(child.c==c.charValue()){
                    next = child;
                    break;
                }
            }

            if(next==null){
                next = new Node(c);
                node.children.add(next);
            }
        }
        return next;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Node root = new Node(null);
        int nullCount=0;

        for(String str:strs){
            if("".equals(str)){
                nullCount++;
            }

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            Node node = root;
            for(int i=0;i<chars.length;i++){
                char cur = chars[i];
                if(i==chars.length-1){
                    List<String> strlist = add(node,cur).strs;
                    strlist.add(str);
                    if(!res.contains(strlist)){
                        res.add(strlist);
                    }
                }else{
                    node = add(node,cur);
                }
            }
        }

        List<String> strlist = new ArrayList<>();
        for (int i = 0; i < nullCount; i++) {
            strlist.add("");
        }

        if(nullCount>0){
            res.add(strlist);
        }

        return res;
    }
}
