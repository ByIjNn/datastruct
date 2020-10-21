package com.binblink.sort;

/*
 * 冒泡排序：对数组中的数据，依次比较相邻两个元素的大小，如1 2 比较 2 3 比较，依据升序或者降序，取大或小，交换位置
 * 对N个数据进行排序，都需要进行N-1次中间排序。冒泡排序缺点：效率不高。
 */
public class BubbleSort {
	static final int SIZE = 10;
	
	public static void bubbleSort(int[] a){
		int temp;
		for(int i=1;i<a.length;i++){
			for(int j = 0; j<a.length-i;j++){
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] =temp;
				}
			}
			System.out.println("第" + i + "步排序结果：");
			for(int k = 0;k<a.length;k++){
				System.out.print( " " + a[k]);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int[] m = new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++){
			m[i]=(int) (100 + Math.random()*(100+1));//产生随机数初始化数组
		}
		System.out.println("排序前数组为：");
		for(i=0;i<SIZE;i++){
			System.out.print(m[i]+" ");
		}
		System.out.println("\n");
		
		bubbleSort(m);
		System.out.println("排序后数组为：");
		for(i=0;i<SIZE;i++){
			System.out.print(m[i]+ " ");
		}
		System.out.println("\n");
	}

}
