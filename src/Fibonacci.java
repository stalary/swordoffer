
/**
 * Fibonacci
 * <p>
 * 斐波那契数列
 *
 * @author lirongqian
 * @since 2018/02/14
 */
public class Fibonacci {

    public int Fibonacci(int n) {
        if (n <= 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}