
/**
 * IsNumeric
 *
 * 判断一个字符串是不是数值类型，可能包含+，-，小数点，e，E
 * 且e，E之后不能有小数，只能是整数
 * 这个题难度较大，需多次查看
 * @author lirongqian
 * @since 2018/02/02
 */
public class IsNumeric {

    /**
     * 本题的关键在于找到+或者-，小数点，E或者e的位置，过滤掉这些元素进行判断是否有非数值
     */
    /**
     * 声明一个全局的index，用来计算当前遍历的下标
     */
    int index = 0;
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        // 首先先判断一次字符串能否直接被判断为数值，即找到非数值的点
        boolean flag = scanInteger(str);
        // 如果出现小数点，则判断小数点之后是不是无符号数值
        if (index < str.length && str[index] == '.') {
            index++;
            // 当满足去掉小数点后是无符号整数或者满足一开始就是整数时为true
            flag = scanUInteger(str) || flag;
        }
        // 如果出现E或者e，则判断下一位开始是不是一个整数
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            // 之前都为数值，且之后也都为数值
            flag = flag || scanInteger(str);
        }
        // 当flag为true并且已经遍历完最后一个元素时返回true
        return flag && index >= str.length;
    }

    /**
     * 过滤掉符号的判断，然后再调用数字判断的方法
     * @param str
     * @return
     */
    public boolean scanInteger(char[] str) {
        // 首先过滤掉开头的正负号
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        // 判断后面的数值
        return scanUInteger(str);
    }

    /**
     * 当前下标为数字时，向后移动并返回true
     * @param str
     * @return
     */
    public boolean scanUInteger(char[] str) {
        int temp = index;
        // 如果存在数字，则+1，当遇到非数字时停止
        while (index < str.length && (str[index] >= '0' && str[index] <= '9')) {
            index++;
        }
        // 当有数字时即返回true
        return index > temp;
    }
}