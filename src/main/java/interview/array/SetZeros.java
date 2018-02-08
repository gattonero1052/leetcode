package interview.array;

import utils.Printer;

/**
 * Created by zly on 2018/2/6.
 * A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution
 */
public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,0,5,2},
                {8,9,2,0},
                {5,7,2,1}
        };

        setZeroes(matrix);

        Printer.print(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        if(matrix.length>0){
            int h = matrix.length,w = matrix[0].length;
            boolean zeroh = false,zerow = false;

            for(int i=0;i<h;i++)
                if(matrix[i][0]==0){
                    zeroh = true;
                }

            for(int i=0;i<w;i++)
                if(matrix[0][i]==0){
                    zerow = true;
                }

            for(int i=1;i<h;i++)
                for(int j=1;j<w;j++)
                    if(matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }

            for(int i=1;i<h;i++)
                if(matrix[i][0]==0){
                    emptyX(matrix,i);
                }

            for(int i=1;i<w;i++)
                if(matrix[0][i]==0){
                    emptyY(matrix,i);
                }

            if(zerow){
                emptyX(matrix,0);
            }

            if(zeroh){
                emptyY(matrix,0);
            }
        }
    }

    public static void emptyX(int[][] matrix,int y){
        for(int i=0;i<matrix[0].length;i++){
            matrix[y][i]=0;
        }
    }

    public static void emptyY(int[][] matrix,int x){
        for(int i=0;i<matrix.length;i++){
            matrix[i][x]=0;
        }
    }
}
