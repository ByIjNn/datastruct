package binblink.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author binblink
 * @Create Time　2018/3/27 21:43
 * @Description:插入排序
 */
public class InsertSort {

    /*
     * @Author binblink
     * @Description: 直接插入
     * @Date 2018/3/27 23:56
     * @Param [arr]
     * @Return void
     */
    public static void directlyInsert(int[] arr){

        for (int i = 2; i < arr.length ; i++) {

            if(arr[i]<arr[i-1]){

                int temp = arr[i];

                //j>=0 必须在前面 而且必须是&& 否则会在j=-1 的时候再判断一次arr[j] > temp引起数组下标越界异常
                for(int j = i-1; (j >= 0 && arr[j] > temp); --j){
                    arr[j+1]=arr[j];
                    arr[j] = temp;
                }
            }


        }
    }

    /*
     * @Author binblink
     * @Description: 折半插入 二分查找后插入
     * @Date 2018/3/28 23:40
     * @Param [arr]
     * @Return void
     */
    public static void halfSearchInsert(int[] arr){

        for (int i = 2; i <arr.length ; i++) {

            int temp = arr[i];
            int low = 0;
            int height = i-1;

            if(arr[i]>arr[i-1]){
                continue;
            }

            while(low <= height){
                int mid = (low + height)/2;

                if(temp<arr[mid]){
                    height = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            for(int j = i-1;j>=height+1;--j){
                arr[j+1] =arr[j];
            }
            arr[height+1]=temp;
        }


    }


    public static void main(String[] args) {

        int[] m = {-2,25,48,-789,5,234,34,146,65,-14,546,456,44,33,22,657};

//        Object[] d = new Object[10];
//        List<String> f = new ArrayList<String>();
//        d[0] = f;
//        char k = 'Z';
//
//        System.out.println((-789>-789));
//        System.out.println((char)(((int)k)-1));

        for(int l : m){

            System.out.print(l+",");
        }
        System.out.println();
        System.out.println("-----------before---------");

//        directlyInsert(m);
        halfSearchInsert(m);
        System.out.println("-----------after---------");

        for(int l : m){

            System.out.print(l+",");
        }
    }
}
