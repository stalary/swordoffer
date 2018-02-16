/**
 * FindGreatestSumOfSubArray
 * <p>
 * 连续子数组的最大和
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class FindGreatestSumOfSubArray {

    /**
     * 利用打擂的思想，当前和为负数时，即更换为当前元素
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                // 替换元素
                curSum = array[i];
            } else {
                // 继续打擂，增添元素
                curSum += array[i];
            }
            // 当前值大于最大值时，更新最大值
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }
}