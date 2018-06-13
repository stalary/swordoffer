
import java.util.ArrayList;

/**
 * FindContinuousSequence
 * <p>
 * 和为S的连续正数序列
 *
 * @author lirongqian
 * @since 2018/02/06
 */
public class FindContinuousSequence {

    /**
     * 先假设一个最小值，一个最大值，然后进行计算结果，满足则循环加入list，最小值和最大值都++
     * 如果和小于sum，则最大值++，即增加一个元素
     * 如果和大于sum，则最小值++，即减少一个元素
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int small = 1;
        int big = 2;
        // 当最小值大于和的一半时，代表没有两个值相加可以得到sum，所以停止
        while (small <= sum / 2) {
            int result = sum(small, big);
            // 当相等时，循环遍历添加进元素
            if (result == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                // 添加完成后，序列整体后移一位
                lists.add(list);
                small++;
                big++;
            }
            // 当小于sum时, 增加一个元素
            if (result < sum) {
                big++;
            } else {
                // 大于sum时，减少一个元素
                small++;
            }
        }
        return lists;
    }

    public int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}