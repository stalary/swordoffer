/**
 * @(#)FirstNotRepeatingChar.java, 2018-02-07.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FirstNotRepeatingChar
 * <p>
 * 第一个只出现一次的字符
 *
 * @author lirongqian
 * @since 2018/02/07
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("aba"));
    }

    public int FirstNotRepeatingChar(String str) {
        char[] c = str.toCharArray();
        int[] a = new int['z' + 1];
        for (char d : c) {
            // 出现一次即加1
            a[d]++;
        }
        for (int i = 0; i < c.length; i++) {
            // 当找到只出现一次的时候直接返回下标
            if (a[c[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar1(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}