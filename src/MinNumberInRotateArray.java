
/**
 * MinNumberInRotateArray
 * <p>
 * 求旋转数组的最小值
 *
 * @author lirongqian
 * @since 2018/02/14
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray1(new int[] {
                7,8,8,9,1,1,1,2,3
        }));
    }

    /**
     * 不断的缩小范围，最后找到最小值
     * <p>
     * (1)array[mid] > array[high]:
     * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
     * low = mid + 1
     * (2)array[mid] == array[high]:
     * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
     * 还是右边,这时只好一个一个试 ，
     * high = high - 1
     * (3)array[mid] < array[high]:
     * 出现这种情况的array类似[7,8,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
     * 边。因为右边必然都是递增的。
     * high = mid
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            // 当mid大于high，则代表最小值在mid的右侧
            if (array[mid] > array[high]) {
                low = mid + 1;
                // 当mid等于high，则无法判断在哪一边，需要一个个判断
            } else if (array[mid] == array[high]) {
                high = high - 1;
                // 当mid小于high时，则代表最小值在mid的左边
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    /**
     * 当不包含重复元素时
     */
    public int minNumberInRotateArray1(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            }
        }
        return array[low];
    }
}