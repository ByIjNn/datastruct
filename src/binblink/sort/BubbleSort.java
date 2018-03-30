package binblink.sort;

/**
 * @Author binblink
 * @Create Time　2018/3/27 20:17
 * @Description:冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] unsortArr){

        for(int i = 0;i<unsortArr.length-1;i++){

            for(int j = 0;j<unsortArr.length-i-1;j++){


                if(unsortArr[j]>unsortArr[j+1]){

                    unsortArr[j] = unsortArr[j] + unsortArr[j+1];
                    unsortArr[j+1] = unsortArr[j]-unsortArr[j+1];
                    unsortArr[j] = unsortArr[j]-unsortArr[j+1];
                }
            }
        }

    }

    public static void sortDesc(int[] unsortArr){

        for(int i = 0;i<unsortArr.length-1;i++){

            for(int j = 0;j<unsortArr.length-i-1;j++){


                if(unsortArr[j]<unsortArr[j+1]){

                    unsortArr[j] = unsortArr[j] + unsortArr[j+1];
                    unsortArr[j+1] = unsortArr[j]-unsortArr[j+1];
                    unsortArr[j] = unsortArr[j]-unsortArr[j+1];
                }
            }
        }

    }

    public static void main(String[] args) {

        int[] s = {12,15,5,-55,6,-84,5,6,1,8,6,20,2,654,3};



        for(int l:s){
            System.out.print(l+",");
        }

        System.out.println("before sort---------");

        System.out.println("after sort---------");

        sortDesc(s);

        for(int l:s){
            System.out.print(l+",");
        }
    }
}
