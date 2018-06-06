import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSum15
 * 三个数字想加等于0的集合
 *
 * @author lirongqian
 * @since 2018/05/20
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum15().threeSum(arr));
    }

    /**
     * 使用一个头指针，一个尾指针，进行计算
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 因为三个元素相加，所以要-2，防止数组越界
        for (int i = 0; i < nums.length - 2; i++) {
            // 对当前数字取负数，判断是否有相加等于0的两个元素
            int twoSum = -nums[i];
            // 当前元素的下一个(当前最小元素)
            int p1 = i + 1;
            // 最后一个元素(当前最大元素)
            int p2 = nums.length - 1;
            // 当还可以往后继续遍历时
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                // 当满足条件时
                if (sum == twoSum) {
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    int prevP1 = p1;
                    // 当还可以向后移动时，向后移动一个元素，如果元素相同时，则继续移动
                    while (p1 < p2 && nums[p1] == nums[prevP1]) {
                        p1++;
                    }
                    // 尾指针减小
                    p2--;
                } else if (sum < twoSum) {
                    // 当小于时，即增大最小值
                    p1++;
                } else {
                    // 当大于时，即增大最大值
                    p2--;
                }
            }
            // 当前遍历的点
            int prevI = i;
            // 当小于最大值时并且元素不相同时，则向后移动，防止遍历相同的元素，重复求值
            while (i < nums.length && nums[i] == nums[prevI]) {
                i++;
            }
            i--;
        }
        return result;
    }
}