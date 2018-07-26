
import java.util.*;
import java.util.stream.Collectors;

/**
 * Permutation
 * <p>
 * 按字典序打印出该字符串中字符的所有排列
 *
 * @author lirongqian
 * @since 2018/02/09
 */
public class Permutation {

    /**
     * 首先将第一个元素与其他元素进行交换
     * 然后将被交换元素锁定，继续交换，即完成了全排序
     *            abc
     *    abc     bac      cba
     * abc  cba bac bca  cba  cab
     * @param
     * @return
     */

    public static void main(String[] args) {
        String str = new String("abcd");
        System.out.println(new Permutation().Permutation1(str));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return list;
        }
        help(str.toCharArray(), 0, list);
        // 最后按字典顺序排序
        Collections.sort(list);
        return list;
    }

    public void help(char[] chars, int i, ArrayList<String> list) {
        // 判断是最后一层时再输入数组
        if (i == chars.length - 1) {
            String str = String.valueOf(chars);
            // 防止重复输入
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                // 交换两个元素
                swap(chars, i, j);
                // 添加入list
                help(chars, i + 1, list);
                // 元素归位
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str.length() == 0) {
            return ans;
        }
        char[] num = str.toCharArray();
        // 首先存入第一个元素进行固定
        ans.add("" + num[0]);
        // 从第二个元素开始排序
        for (int i = 1; i < num.length; ++i) {
            ArrayList<String> lists = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                for (String s : ans) {
                    // 每次向不同的位置进行插入
                    String pre = s.substring(0, j);
                    String end = s.substring(j);
                    String temp = pre + num[i] + end;
                    lists.add(temp);
                }
            }
            ans = lists;
        }
        return ans.stream().distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

}