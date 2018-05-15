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
        int a[] = {2, 4, 3, 7, 9, 1, 17, 18, 0, 20};
        int k = 6;
        new GetLeastNumbers().getTopKMinBySort(a, 0, a.length - 1, k);
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
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
     * 使用快速排序过程法
     * i > k - 1时,向左移动继续缩小范围
     * i < k - 1时，开始向右移动，增加
     * @param a
     * @param first
     * @param end
     * @return
     */
    int partition(int a[], int first, int end) {
        int i = first;
        int key = a[end];
        for (int j = first; j < end; j++) {
            if (a[j] < key) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        a[end] = a[i];
        a[i] = key;
        System.out.println(i);
        return i;
    }

    void getTopKMinBySort(int a[], int first, int end, int k) {
        if (first < end) {
            int partitionIndex = partition(a, first, end);
            if (partitionIndex == k - 1) {
                return;
            } else if (partitionIndex > k - 1) {
                getTopKMinBySort(a, first, partitionIndex - 1, k);
            } else {
                getTopKMinBySort(a, partitionIndex + 1, end, k);
            }
        }
    }


}