
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FirstAppearingOnce
 *
 * 从数据流中找到第一个只出现一次的字符
 * @author lirongqian
 * @since 2018/02/02
 */
public class FirstAppearingOnce {

    /**
     * 维护一个全局的LinkedHashMap，从数据流中存储char，并统计数量
     */
    Map<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch) {
        // getOrDefault为当key对应的value不存在时，则赋默认值
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public char FirstAppearingOnce() {
        // 遍历map，拿到第一次出现value为1的key
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}