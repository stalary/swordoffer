
/**
 * JumpFloorII
 *
 * 变态跳
 * 青蛙可以跳1，2到n层台阶，求上n层有多少种方法
 * @author lirongqian
 * @since 2018/02/14
 */
public class JumpFloorII {

    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= target; i++) {
            arr[i] = 2 * arr[i - 1];
        }
        return arr[target];
    }
}