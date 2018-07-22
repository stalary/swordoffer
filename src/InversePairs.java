/**
 * InversePairs
 * <p>
 * 计算逆序对的数量，前面数字大于后面的数字，即代表一个逆序对
 *
 * @author lirongqian
 * @since 2018/02/07
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] array = new int[] {
                9, 8, 7, 6, 4, 5, 1, 6
        };
        System.out.println(new InversePairs().divide(array, 0, array.length - 1));
    }

    public int divide(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide(array, left, mid);
            divide(array, mid + 1, right);
            return merge(array, left, mid, right);
        }
        return 0;
    }

    private int count = 0;

    public int merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
                count += mid - leftIndex + 1;
            }
        }
        while (leftIndex <= mid) {
            temp[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = array[rightIndex++];
        }
        // 将临时数组放回原数组中实现排序
        int t = 0;
        while ((t + left) <= right) {
            array[t + left] = temp[t];
            t++;
        }
        return count;
    }
}