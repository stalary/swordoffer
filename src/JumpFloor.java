
/**
 * JumpFloor
 *
 * 跳台阶，可以跳1或者2层，求跳上n层一共有多少种方法，
 * 与矩阵覆盖相同
 * @author lirongqian
 * @since 2018/02/14
 */
public class JumpFloor {

    public int JumpFloor(int target) {
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