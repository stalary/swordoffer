/**
 * @(#)StrToInt.java, 2018-02-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * StrToInt
 *
 * 把字符串转化为整数
 * @author lirongqian
 * @since 2018/02/04
 */
public class StrToInt {

    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt("+123"));
    }

    /**
     * 首先判断正负号，然后求出每一位，当有不是数字的时候直接返回0
     * @param str
     * @return
     */
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        // 判断符号
        boolean flag = true;
        // 字符串当前下标
        int index = 0;
        if (chars[0] == '-') {
            flag = false;
            index++;
        } else if (chars[0] == '+') {
            index++;
        }
        int sum = 0;
        for (int i = index; i < str.length(); i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                sum = sum * 10 + chars[i] - '0';
            } else {
                return 0;
            }
        }
        return flag ? sum : -sum;
    }
}