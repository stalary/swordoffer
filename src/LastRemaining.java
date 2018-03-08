
/**
 * LastRemaining
 *
 * 圆圈中最后剩下的数
 * @author lirongqian
 * @since 2018/02/04
 */
public class LastRemaining {

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        // 通过找规律可以发现每次最后剩下的数字是上次最后剩下的数字加退出的人取模于总人数
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}