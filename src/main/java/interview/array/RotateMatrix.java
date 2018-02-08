package interview.array;


import utils.Printer;

/**
 * Created by zly on 2018/2/5.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1}
        };

        rotate(matrix);

        Printer.print(matrix);
    }

    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int i=size;i>1;i-=2){
            for(int j=0;j<i-1;j++){
                for(int k=0,start = (size-i)/2;k<3;k++)
                    swap(matrix,start,start+j,i,k);

            }
        }
    }

    public static void swap(int[][] matrix,int i,int j,int size,int count){
        int m=0,n=0,max = i+size-1,sub = max-j+i;

        if(count==0){
            m = j;
            n = max;
        }

        if(count==1){
            m = max;
            n = sub;
        }

        if(count==2){
            m = sub;
            n = i;
        }

        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
