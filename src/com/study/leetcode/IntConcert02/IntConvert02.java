package com.study.leetcode.IntConcert02;

/**
 * @author fingernight
 * @version 1.0
 * @date 2020/9/8 11:53 下午
 */
public class IntConvert02 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int reverse(int x) {
        int mul = 1;
        if(x < 0){
            mul = -1;
        }
        String intString = String.valueOf(x);
        if(intString.startsWith("-")){
            intString = intString.substring(1);
        }

        StringBuffer buffer = new StringBuffer(intString);
        buffer.reverse();
        int reverse = 0;
        try {
            reverse = Integer.parseInt(buffer.toString());
        }catch (Exception e){

        }
        return  reverse * mul;
    }

    public static int reveseInt(int x){
        int MAXVALUE = 2147483647;   //最大值
        int MINVALUE = -2147483648;   //最小值

        int revese = 0;
        while (x != 0){
            //取末尾数字
            int temp = x % 10;
            //判断是否大于最大正数
            if(revese > MAXVALUE /10 || (revese == MAXVALUE/10 && temp > 7)){
                return 0;
            }
            //判断是否小于最小整数
            if(revese < MINVALUE / 10 || (revese == MINVALUE/10 && temp > 8)){
                return 0 ;
            }
            revese = revese * 10 + temp;
            x /= 10;
        }
        return revese;
    }
    public static void main(String[] args) {
        int reverseInt = 123;
        System.out.println(reverseInt);
        System.out.println(reveseInt(reverseInt));
//        System.out.println(Integer.reverse(reverseInt));
    }
}
