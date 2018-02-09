package interview.design;

import utils.Printer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zly on 2018/2/9.
 *
 * 这边是序列化和反序列化一棵树，OJ 只判断树的结构，不判断序列化的结果
 *
 * String.split 方法的注意点
 * ",a,,a,".split(",") 的结果是 ["a","","a"] 不包含末尾的的空字符串，但包括开始的空字符串
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        String data = serialize(root);
        Printer.print(data);
        TreeNode toor = deserialize(data);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //这里实现一个队列结构，然后先序遍历即可
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        sb.append(root==null?',':root.val+",");

        int notNullCount = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(cur!=null){
                notNullCount--;
                queue.add(cur.left);
                queue.add(cur.right);

                if(cur.left!=null){
                    sb.append(String.valueOf(cur.left.val)+",");
                    notNullCount++;
                }else{
                    sb.append(',');
                }

                if(cur.right!=null){
                    sb.append(String.valueOf(cur.right.val)+",");
                    notNullCount++;
                }else{
                    sb.append(',');
                }
            }else if(notNullCount>0){
                queue.add(null);
                queue.add(null);
                sb.append(',');
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        int notNullCount = 0;

        if(nodes.length>0){
            root = new TreeNode(Integer.parseInt(nodes[0]));
            queue.add(root);
            notNullCount = 1;
        }


        for (int i = 1; i < nodes.length-1; i+=2) {
            TreeNode cur = queue.poll();
            if(!nodes[i].equals("")){
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
            }

            if(!nodes[i+1].equals("")){
                cur.right = new TreeNode(Integer.parseInt(nodes[i+1]));
            }

            if(cur!=null){
                notNullCount--;
                if(cur.left!=null)
                    notNullCount++;
                if(cur.right!=null)
                    notNullCount++;

                queue.add(cur.left);
                queue.add(cur.right);
            }else if(notNullCount>0){
                queue.add(null);
                queue.add(null);
            }
        }

        return root;
    }

}
