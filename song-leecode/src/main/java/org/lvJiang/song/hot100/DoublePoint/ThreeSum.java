package org.lvJiang.song.hot100.DoublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：三数之和
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{1,2,-2,-1});
        System.out.println(11);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length-2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i=k+1;
            int j= nums.length-1;
            while (i<j){
                if (nums[k] + nums[i] + nums[j] > 0) {
                    while(i<j && nums[j] == nums[--j]);
                } else if (nums[k] + nums[i] + nums[j] < 0) {
                    while(i<j && nums[i] == nums[++i]);
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }
}
