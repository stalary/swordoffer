
/**
 * LeftRotateString
 *
 * 左移字符串
 * @author lirongqian
 * @since 2018/02/06
 */
public class LeftRotateString {

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().LeftRotateString("abcdefg", 2));
    }

    /**
     * 将字符串自身相加，然后截取n到数组长度+n的部分
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        // 一定要先求出字符串长度，否则截取时长度过大，会数组越界
        int len = str.length();
        if (str.length() == 0) {
            return "";
        }
        str += str;
        // 从第n位开始截取
        return str.substring(n, n + len);
    }
}