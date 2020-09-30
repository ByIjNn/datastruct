package com.binblink.leetcode.simple;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
 */
public class FindIndexByTarget {

    int[] arr = {15,12,3,8,6,1,5,4,6,4,46,18,23,4,9};

    public class Result {

        private int index1;
        private int index2;


        @Override
        public String toString() {
            return "index1:"+index1 +"------"+"index2:"+index2;
        }

        public Result setIndex1(int index1) {
            this.index1 = index1;
            return this;
        }


        public Result setIndex2(int index2) {
            this.index2 = index2;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Result result = (Result) o;

            if (index1 == result.index1 || index1 == result.index2 ||
                    index2 == result.index2 || index2 == result.index1){
                return true;
            }

            return false;
        }


    }

    public  List<Result> getIndex(Integer target){

        if(Objects.isNull(target)){
            throw new NullPointerException("参数不能为空！");
        }
        List<Result> results =new ArrayList<>();

        for(int i = 0;i<arr.length;i++){
               for(int j = i+1;j<arr.length;j++){


                   int temp = arr[i] + arr[j];

                   if(target.equals(temp)){
                      Result result = new Result().setIndex1(i).setIndex2(j);
                      boolean eq = false;
                       for(Result r:results){
                           if(result.equals(r)){
                               eq = true;
                               break;
                           }
                       }

                       if(!eq){
                           results.add(result);
                       }
                       break;
                   }
               }

        }

        return results;
    }

    public static void main(String[] args){
        Integer target = 10;
        FindIndexByTarget findIndexByTarget =  new FindIndexByTarget();

        List<Result> results = findIndexByTarget.getIndex(target);

        if(results.isEmpty()){
            System.out.println("数组中找不到符合的元素！无结果！");
        }else{
            for(Result r : results){
                System.out.println(r.toString());
            }
        }



    }


}
