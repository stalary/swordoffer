
/**
 * ReverseSentence
 *
 * 翻转单词
 * @author lirongqian
 * @since 2018/02/06
 */
public class ReverseSentence {

    /**
     * 首先截取字符串，然后再进行倒置
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0 || "".equals(str.trim())) {
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        sb.append(strings[0]);
        return sb.toString();
    }
}