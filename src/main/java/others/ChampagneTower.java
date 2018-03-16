package others;

/**
 * Created by zly on 2018/3/16.
 */
public class ChampagneTower {
    public static void main(String[] args) {

    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[100][100];
        tower[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(tower[i][j]>1){
                    tower[i+1][j]+=(tower[i][j]-1)/2.0;
                    tower[i+1][j+1]+=(tower[i][j]-1)/2.0;
                }
            }
        }

        return tower[query_row][query_glass]>1?1:tower[query_row][query_glass];
    }
}
