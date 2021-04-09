package com.binblink.leetcode.medium;


/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *  
 * <p>
 * 进阶：
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RevoleNums {


    public static int findNumb(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;


        while (end > start) {
            int mid = (end - start) / 2 + start;
            int midValue = arr[mid];
            int startValue = arr[start];
            int endValue = arr[end];

            if (target == midValue) {
                return mid;
            }

            //k值在左区
            if (midValue < startValue) {

                if (target < midValue) {
                    end = mid;
                    continue;
                }

                if (target > midValue) {
                    if (target == endValue) {
                        return end;
                    }

                    if (target < endValue) {
                        //在右区二分
                        start = mid;
                        continue;
                    }

                    if (target > endValue) {
                        //在左区二分
                        end = mid;
                        continue;
                    }
                }
            }

            //k在右区或当前数组已经完全升序
            if (midValue > startValue) {

                if (target < midValue) {

                    if (target == startValue) {
                        return start;
                    }

                    if (target > startValue) {
                        end = mid;
                        continue;
                    }

                    if (target < startValue) {
                        start = mid;
                        continue;
                    }
                }
                if (target > midValue) {
                    start = mid;
                    continue;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int arr[] = {24, 33, 35, 37, 38, 44, 47, 49, 77, 89, 90, 1, 2, 3, 4, 5, 6, 7, 8, 16, 17, 18};

        System.out.println(findNumb(arr, 18));

    }
}
