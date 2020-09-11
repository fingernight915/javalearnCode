package com.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一道题，求两个数之和
 */
class no1_two_num_sumn {

    public static void main(String[] args) throws Exception {
        
        int[] nums = {3,2,4};
        int[] result;
        result = twoSum3(nums,6);
        System.out.println("["+result[0]+","+result[1]+"]");
    }

    /**
     * 第一个版本
     * @param nums 目标数组
     * @param target 目标值
     * @return 满足目标值的元素下标
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        int flag = 0;
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 1; j < nums.length; j++){
                if(i == j ){
                    continue;
                }
                if(nums[i] + nums[j] == target){
                    array[0] = i;
                    array[1] = j;
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
        }
        return array;
    }

    /**
     * haspMap实现，时间复杂度度为O(n),空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums,int target) throws Exception {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            int sum = target - nums[i];
            if(map.containsValue(sum) && map.get(sum) != i){
                return new int[] {i,map.get(sum)};
            }
        }
        throw new Exception("不存在两个数字相加等于目标值的元素");
    }

    /**
     * haspMap 实现，遍历一遍哈希表，时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums,int target) throws Exception {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
            int sum = target - nums[i];
            if(map.containsValue(sum) && map.get(sum) != i){
                return new int[] {i,map.get(sum)};
            }
        }
        throw new Exception("不存在两个数字相加等于目标值的元素");
    }
}
