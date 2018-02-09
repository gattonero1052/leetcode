package interview.sortingandsearching;

/**
 * Created by zly on 2018/2/9.
 * 注意横向和纵向都是有序的
 * 题目对算法效率有要求，那么我们可以使用一个Omn的算法
 *
 * 比较容易出现越界的情况，需要特别判断
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
//        Printer.print(searchMatrix(new int[][]{
//                {5,6,9},
//                {9,10,11},
//                {11,14,18},
//        },9));
//
//        Printer.print(searchMatrix(new int[][]{
//            {1,   4,  7, 11, 15},
//            {2,   5,  8, 12, 19},
//            {3,   6,  9, 16, 22},
//            {10, 13, 14, 17, 24},
//            {18, 21, 23, 26, 30}
//        },5));
//
//        Printer.print(searchMatrix(new int[][]{
//                {1}
//        },1));

//        Printer.print(searchMatrix(new int[][]{
//                {1,1}
//        },2));
//
//        Printer.print(searchMatrix(new int[][]{
//            {1,   4,  7, 11, 15},
//            {2,   5,  8, 12, 19},
//            {3,   6,  9, 16, 22},
//            {10, 13, 14, 17, 24},
//            {18, 21, 23, 26, 30}
//        },20));
//
//        Printer.print(searchMatrix(new int[][]{
//                {1,   4},
//                {2,   5}
//        },0));
//
//        Printer.print(searchMatrix(new int[][]{
//                {1,   4},
//                {2,   5}
//        },9));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)return false;

        int startx = 0,starty = 0,endx = matrix[0].length-1,endy = matrix.length-1;

        while(startx<=endx && starty<=endy){
            while(endx>=0 && matrix[starty][endx]>target)endx--;
            while(endy>=0 && matrix[endy][startx]>target)endy--;
            while(endy>=0 && startx<matrix[0].length && matrix[endy][startx]<target)startx++;
            while(endx>=0 && starty<matrix.length && matrix[starty][endx]<target)starty++;

            if(starty<matrix.length && startx<matrix[0].length &&
                    endy>=0 && endx>=0 &&
                    (matrix[starty][startx]==target || matrix[endy][endx]==target || matrix[starty][endx]==target || matrix[endy][startx]==target))
                return true;
        }

        return false;
    }
}
