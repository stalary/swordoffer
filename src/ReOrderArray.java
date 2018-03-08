
/**
 * ReOrderArray
 *
 * 调整数组顺序使奇数位于偶数前面
 * @author lirongqian
 * @since 2018/02/13
 */
public class ReOrderArray {

    /**
     * 利用类似于插入排序的思想
     * @param array
     */
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] % 2 == 0 && array[j] % 2 != 0) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}