
/**
 * GetUglyNumber
 * <p>
 * 求第n个丑数
 * 只包含因子2、3和5的数称作丑数
 *
 * @author lirongqian
 * @since 2018/02/08
 */
public class GetUglyNumber {

    public int GetUglyNumber_Solution(int index) {
        // 1 2 3 4 5 6都是丑数，所以小于时直接返回
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i) {
            // 将2，3，5进行组合
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            // 求出每个元素的数量
            if (res[i] == res[t2] * 2) {
                t2++;
            }
            if (res[i] == res[t3] * 3) {
                t3++;
            }
            if (res[i] == res[t5] * 5) {
                t5++;
            }
        }
        // 返回最后一个元素
        return res[index - 1];
    }
}