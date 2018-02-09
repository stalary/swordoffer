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

    //step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果
    //step2:异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果
    //step3:没有进位位了，如果有，需要重复step1、step2；如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果
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