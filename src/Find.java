/**
 * Find
 * <p>
 * 二维数组中的查找
 *
 * @author lirongqian
 * @since 2018/02/15
 */
public class Find {

    public boolean Find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (col >= 0 && row < array.length) {
            if (target < array[row][col]) {
                col--;
            } else if (target > array[row][col]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}