package com.binblink.sort;

/**
 * @author:binblink
 * @Description ：快速排序
 * @Date: Create on  2018/4/1 11:24
 * @Modified By:
 * @Version:1.0.0
 **/
public class QuickSort {

    public static  int quickSort(int[] arr,int low ,int height){

        int keyvalue = arr[low];

        while(low<height){
            int temp ;
            while (low<height&&arr[height]>=keyvalue){
                height--;
            }
            arr[low] = arr[height];

            while(low<height&&arr[low]<=keyvalue){
                low++;
            }

            arr[height] = arr[low];
        }
        arr[low] = keyvalue;

        return low;

    }

    public static  void sort(int arr[],int lo,int hei){

        if(lo>=hei){
            return;
        }
        int index = quickSort(arr,lo,hei);

       sort(arr,0,index-1);
       sort(arr,index+1,hei);
    }

    public static void main(String[] args) {

        int[] m = {-2,25,48,-789,5,234,34,146,65,-14};

        for(int l : m){

            System.out.print(l+",");
        }

        System.out.println("-----------before---------");

        sort(m,0,m.length-1);
        System.out.println("-----------after---------");

        for(int l : m){

            System.out.print(l+",");
        }
    }
}
