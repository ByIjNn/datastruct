package com.binblink.sort;

/**
 * @author:binblink
 * @Description 希尔排序 特殊的插入排序
 * @Date: Create on  2018/3/31 15:26
 * @Modified By:
 * @Version:1.0.0
 *
 *

 *
 *
 **/
public class ShellSort {

    /*
     *@Author:binblink
     *@Description:希尔排序
     *@Date:2018/3/31 15:28
     *@param:
    **/
    public static void shellSort(int[] arr){

        int addstep = arr.length;//增量
        addstep = addstep/2;
        while(addstep>=1){
            System.out.println("增量为："+addstep);
            for (int i = addstep; i <arr.length ; i+=addstep) {
                if(arr[i]<arr[i-addstep]){
                        int temp = arr[i];

                        for(int j =i-addstep;j>=0&&temp<arr[j];j-=addstep){
                            arr[j+addstep] = arr[j];
                            arr[j] = temp;
                        }
                }
            }
            addstep = addstep/2;
        }
    }

    public static void main(String[] args) {
        int[] m = {-2,25,48,-789,5,234,34,146,65,-14,546,456,44,33,22,657};

        for(int l : m){

            System.out.print(l+",");
        }

        System.out.println("-----------before---------");

        shellSort(m);
        System.out.println("-----------after---------");

        for(int l : m){

            System.out.print(l+",");
        }
    }
}
