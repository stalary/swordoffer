/**
 * ReplaceSpace
 * <p>
 * 替换空格
 *
 * @author lirongqian
 * @since 2018/02/15
 */
public class ReplaceSpace {

    /**
     * 如何直接使用正则表达式替换速度会很慢，所以首先计算出空格的数量，从末尾进行替换
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int blank = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                blank++;
            }
        }
        int oldLen = len - 1;
        int newLen = len + 2 * blank;
        int index = newLen - 1;
        str.setLength(newLen);
        // 从末尾开始遍历，当遇到空格时进行替换，非空格时即将原元素放入
        for (; oldLen >= 0; oldLen--) {
            if (str.charAt(oldLen) == ' ') {
                str.setCharAt(index--, '0');
                str.setCharAt(index--, '2');
                str.setCharAt(index--, '%');
                blank--;
            } else {
                str.setCharAt(index--, str.charAt(oldLen));
            }
            if (blank == 0) {
                return str.toString();
            }
        }
        return str.toString();
    }

    public String replaceSpace1(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}