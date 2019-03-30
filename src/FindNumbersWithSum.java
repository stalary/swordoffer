
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * findNumbersWithSum
 * <p>
 * 在递增数组中，查找两个数和为s，且乘积最小的数
 *
 * @author lirongqian
 * @since 2018/02/06
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = new int[] {
                1, 3, 5, 6, 8, 9
        };
        System.out.println(new FindNumbersWithSum().findNumbersWithSum1(array, 11));
    }

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for (int i : array) {
            if (set.contains(sum - i)) {
                if (min > i * (sum - i)) {
                    min = i * (sum - i);
                    temp = i;
                }
            }
            set.add(i);
        }
        if (temp != 0) {
            result.add(sum - temp);
            result.add(temp);
        }
        return result;
    }

    /**
     * 当和小于目标值时，起点移动，大于时终点移动，否则比较乘积是否最大
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum1(int[] array, int sum) {
        int start = 0;
        int end = array.length - 1;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        int s = 0;
        int e = 0;
        while (start < end) {
            int result = array[start] + array[end];
            if (result == sum) {
                int temp = array[start] * array[end];
                if (temp < min) {
                    s = start;
                    e = end;
                    min = temp;
                }
                start++;
                end--;
            } else if (result < sum) {
                start++;
            } else {
                end--;
            }
        }
        list.add(array[s]);
        list.add(array[e]);
        return list;
    }
}