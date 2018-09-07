
import java.util.HashSet;
import java.util.Set;

/**
 * Duplicate
 * <p>
 * 判断一个数组是否有重复元素，并且返回第一个重复的元素
 *
 * @author lirongqian
 * @since 2018/02/04
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] numbers = new int[] {
                2,1,3,1,4
        };
        int[] duplication = new int[1];
        new Duplicate().duplicate1(numbers, numbers.length, duplication);
        System.out.println(duplication[0]);
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0 || numbers == null) {
            return false;
        }
        // 使用set进行存储，遍历时发现存在时，则进行返回
        Set<Integer> set = new HashSet<>();
        for (int out : numbers) {
            if (set.contains(out)) {
                duplication[0] = out;
                return true;
            }
            set.add(out);
        }
        return false;
    }

    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (length == 0 || numbers == null) {
            return false;
        }
        // 当该数字出现过时，则将数字对应的下标数组加长度，下次判断是否有大于长度的值 2,1,3,1,4
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            // 当numbers受到影响时，要进行恢复
            if (index >= length) {
                index -= length;
            }
            // 代表重复，直接返回
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false;
    }

}