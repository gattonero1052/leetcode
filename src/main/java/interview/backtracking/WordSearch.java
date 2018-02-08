package interview.backtracking;

import java.util.Arrays;

/**
 * Created by zly on 2018/2/7.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean used[][] = new boolean[board.length][board[0].length];

        boolean res = false;
        for (int i = 0; !res && i < board.length; i++) {
            for (int j = 0; !res && j < board[0].length; j++) {
                //empty used
                for(boolean[] obj:used){
                    Arrays.fill(obj,false);
                }

                res |= backtrack(used,board,word,0,i,j);
            }
        }

        return res;
    }

    public static int[][] looper(int y,int x,int width,int height){
        int size = 4;
        if (x==0 || x==width-1)
            size--;

        if (y==0 || y==height-1)
            size--;

        int[][] looper = new int[size][2];

        if (x>0){//left
            looper[size--]= new int[]{y,x-1};
        }

        if (x<width-1){//right
            looper[size--]= new int[]{y,x+1};
        }

        if (y>0){//right
            looper[size--]= new int[]{y-1,x};
        }

        if (y<height-1){//right
            looper[size--]= new int[]{y+1,x};
        }

        return looper;
    }

    public static boolean backtrack(boolean[][] used,char[][] board,String word,int index,int y,int x){
        int[][] looper = looper(y,x,board[0].length,board.length);

        if(!used[y][x]){
            if(word.charAt(index)==board[y][x]){
                used[y][x] = true;
                if(index==word.length()-1)
                    return true;

                boolean res = false;
                for(int[] loop:looper){
                    res |=  backtrack(used,board,word,index+1,loop[0],loop[1]);
                }
                if(!res){
                    used[y][x] = false;
                }else{
                    return true;
                }
            }
        }

        return false;
    }
}
