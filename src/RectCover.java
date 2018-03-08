
/**
 * RectCover
 *
 * 矩阵覆盖
 * @author lirongqian
 * @since 2018/02/14
 */
public class RectCover {

    /**
     * 通过找规律可以发现
     * target：1-》1
     * target：2-》2
     * target：3-》3
     * target：4-》5
     * 所以归纳出公式为arr[i] = arr[i - 1] + arr[i - 2]
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target];
    }
}