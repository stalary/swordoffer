
/**
 * Power
 * <p>
 * 数值的整数次方
 *
 * @author lirongqian
 * @since 2018/02/13
 */
public class Power {

    /**
     * 注意判断负数的时候
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 1.0;
        int temp = exponent > 0 ? exponent : -exponent;
        for (int i = 0; i < temp; i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }
}