
import java.util.ArrayList;

/**
 * PrintMatrix
 * <p>
 * 顺时针打印矩阵
 *
 * @author lirongqian
 * @since 2018/02/12
 */
public class PrintMatrix {

    /**
     * 首先要先求出层数，然后进行遍历
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int n = matrix.length, m = matrix[0].length;
        if (m == 0) {
            return result;
        }
        //层数
        int layers = (Math.min(n, m) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) {
                //左至右
                result.add(matrix[i][k]);
            }
            for (int j = i + 1; j < n - i; j++) {
                //右上至右下
                result.add(matrix[j][m - i - 1]);
            }
            for (int k = m - i - 2; k >= i && n - i - 1 != i; k--) {
                //右至左
                result.add(matrix[n - i - 1][k]);
            }
            for (int j = n - i - 2; j > i && m - i - 1 != i; j--) {
                //左下至左上
                result.add(matrix[j][i]);
            }
        }
        return result;
    }
}