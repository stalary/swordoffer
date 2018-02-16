import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * GetLeastNumbers
 * <p>
 * 最小的k个数
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 5, 1, 6, 2, 7, 3, 8
        };
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(arr, 4));
    }

    /**
     * 使用一个最大堆，首先放入k个元素，然后遍历数组，当出现比堆顶小的即，堆顶出队，入队该值，最后的堆则为最小的k个数
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || k == 0) {
            return result;
        }
        // 申请一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : input) {
            // 当元素数量不足时，进行初始化
            if (maxHeap.size() != k) {
                maxHeap.offer(i);
                // 当堆顶元素大于当前元素时，进行出队，入队当前元素
            } else if (maxHeap.peek() > i) {
                maxHeap.poll();
                maxHeap.offer(i);
            }
        }
        result.addAll(maxHeap);
        return result;
    }

    /**
     * 循环k次，每次保留上一次的最小值，并且下一次筛选最小值时要比上一次的大
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || k == 0) {
            return result;
        }
        // 上一次的最小值
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            // 当前的最小值
            int min = Integer.MAX_VALUE;
            for (int j : input) {
                // 只有当前值小于当前最小值并大于上一次最小值时才更新最小值
                if (j < min && j > temp) {
                    min = j;
                }
            }
            // 更新上一次的最小值
            temp = min;
            // 将当前最小值加入
            result.add(min);
        }
        return result;
    }


}