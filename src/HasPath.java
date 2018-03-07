
/**
 * HasPath
 * 矩阵中的路径
 * @author lirongqian
 * @since 2018/01/30
 */
public class HasPath {

    /**
     * 判断一个矩阵当中是否包含一个指定的路径，因为开始的地方不确定，所以需要使用回溯法，向四个方向进行遍历
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 申请一个标记数组，因为传入的矩阵已经转化为一维数组，所以此处也使用一维数组进行存储
        boolean[] flag = new boolean[matrix.length];
        // 遍历每一个点，当满足条件时即跳出
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (help(matrix, i, j, rows, cols, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean help(char[] matrix, int i, int j, int rows, int cols, char[] str, int k, boolean[] flag) {
        // 下标为当前横坐标*列数+当前列
        // 2 3 4
        // 5 2 8
        // 2的位置为4 -> 1 * 3 + 1
        int index = i * cols + j;
        // 回溯法首先判断边界，然后判断当前的字符是否满足路径，最后判断一下是否已经走过这个点
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        // 当已经走完全程时，即代表路径满足，同时也是防止数组越界
        if (k == str.length - 1) {
            return true;
        }
        // 将当前点设置为已到达
        flag[index] = true;
        // 向四个方向进行搜索，字符串中的下标后移一位
        if (help(matrix, i - 1, j, rows, cols, str, k + 1, flag)
                || help(matrix, i + 1, j, rows, cols, str, k + 1, flag)
                || help(matrix, i, j - 1, rows, cols, str, k + 1, flag)
                || help(matrix, i, j + 1, rows, cols, str, k + 1, flag)) {
            return true;
        }
        // 如果当前点走不到下个点，则回溯
        flag[index] = false;
        return false;
    }
}