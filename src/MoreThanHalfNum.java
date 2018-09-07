
/**
 * MoreThanHalfNum
 * <p>
 * 数组中超过一半的数字
 *
 * @author lirongqian
 * @since 2018/02/09
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum().moreThanHalfNumSolution(new int[]{
                6, 4, 5, 4, 3, 2, 4, 4, 4
        }));
    }

    /**
     * 设置一个哨兵，初始值为第一个元素，当下一个元素相同是，哨兵前进一位，否则后退
     * 当为0时，更换哨兵，最后循环判断留下的哨兵移动的数量，如果大于数组的一半，则输出
     * @param array
     * @return
     */
    public int moreThanHalfNumSolution(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        // 哨兵初始化步数1，元素为第一个元素
        int temp = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            // 步数为0时即切换哨兵
            if (temp == 0) {
                result = array[i];
            }
            // 相同时，哨兵前进，否则后退一步
            if (result == array[i]) {
                temp++;
            } else {
                temp--;
            }
        }
        temp = 0;
        for (int i : array) {
            if (i == result) {
                temp++;
            }
        }
        if (temp > array.length / 2) {
            return result;
        }
        return 0;
    }
}