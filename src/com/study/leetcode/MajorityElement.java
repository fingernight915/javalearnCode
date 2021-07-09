package com.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fingernight
 * @version 1.0
 * @date 2021/7/9 11:58 下午
 */
public class MajorityElement {
    /**
     * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * 示例 2：
     *
     * 输入：[3,2]
     * 输出：-1
     * 示例 3：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 解法1：利用哈希表进行处理
     * 思路：将当前元素作为主键存入map，value为出现次数，如果次数超过一半则返回为主要元素，否则返回-1
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int majorNum = -1;
        for(int num : nums){
            if(map != null){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            if(map.get(num) * 2 > nums.length){
                majorNum = num;
                break;
            }
        }
        return majorNum;
    }

    /**
     * 利用投票法进行处理
     * 原理：
     *      （1）设置备选元素和备选元素次数
     *      （2）循环数组，如果次数为0，则将当前元素赋值到备选元素
     *      （3）备选元素和当前元素进行比较，如果相等则次数加1，否则次数减1
     *      （4）对上面得出的备选元素重新进行校验，循环计算次数，如果超过一半则为真正的主要元素，返回，否则返回-1
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums){
        int majorNum = -1; //备选主要元素
        int count = 0; //备选主要元素出现次数

        //利用投票法获取备选主要元素
        for(int num : nums){
            //如果count==0则将当前元素赋值给备选元素
            if(count == 0){
                majorNum = num;
            }
            //备选元素与当前值进行比较，如果相等则次数加1，否则次数减1
            if(majorNum == num){
                count++;
            }else{
                count--;
            }
        }
        //重新初始化次数为0，验证备选元素是否为真正主要元素
        count = 0;
        //真正主要元素
        int realMajorNum = -1;
        for(int num : nums){
            if(num == majorNum){
                count++;
                if(count * 2 > nums.length){
                    realMajorNum = majorNum;
                }
            }
        }
        return realMajorNum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9,5,9,5,5,5};
        int[] nums1 = {3,2};
        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums1));
    }
}
