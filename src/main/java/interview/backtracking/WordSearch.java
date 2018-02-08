package interview.backtracking;

import utils.Printer;

import java.util.Arrays;

/**
 * Created by zly on 2018/2/7.
 */
public class WordSearch {
    public static void main(String[] args) {
        Printer.print(exist(new char[][]{
            {'A'}
        },""));
    }

    public static boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length==0 || word==null || word.length()==0)
            return false;

        boolean used[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //empty used
                for(boolean[] obj:used){
                    Arrays.fill(obj,false);
                }

                if(backtrack(used,board,word,0,i,j))
                    return true;
            }
        }

        return false;
    }

    public static int[][] looper(int y,int x,int width,int height){
        int size = 4;
        if (x==0 || x==width-1)
            size--;

        if (y==0 || y==height-1)
            size--;

        int[][] looper = new int[size][2];

        if (x>0){//left
            looper[--size]= new int[]{y,x-1};
        }

        if (x<width-1){//right
            looper[--size]= new int[]{y,x+1};
        }

        if (y>0){//right
            looper[--size]= new int[]{y-1,x};
        }

        if (y<height-1){//right
            looper[--size]= new int[]{y+1,x};
        }

        return looper;
    }

    public static boolean backtrack(boolean[][] used,char[][] board,String word,int index,int y,int x){
        if(!used[y][x]){
            if(word.charAt(index)==board[y][x]){
                int[][] looper = looper(y,x,board[0].length,board.length);

                used[y][x] = true;
                if(index==word.length()-1)
                    return true;

                for(int[] loop:looper){
                    if(backtrack(used,board,word,index+1,loop[0],loop[1]))
                        return true;
                }

                used[y][x] = false;
            }
        }

        return false;
    }
}
