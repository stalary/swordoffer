/**
 * @(#)Add.java, 2018-02-03.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Add
 *
 * 不使用运算符做加法
 * @author lirongqian
 * @since 2018/02/03
 */
public class Add {

    public int add(int num1,int num2) {
        //  当没有进位的时输出
        while (num2 != 0) {
            // 求出未进位时的数
            int temp = num1 ^ num2;
            // num2为进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}