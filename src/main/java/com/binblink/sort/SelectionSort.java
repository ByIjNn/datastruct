package com.binblink.sort;

/*
 * 选择排序：先从原始数组中选出一个最小的数据，将其与第一个位置的数据交换。然后接着从剩下的n-1中找出最小的，与第二
 * 个位置的数据交换。依次类推不断重复，直到最后两个数据完成交换。
 * 缺点：效率不高  都要执行N-1步
 */
public class SelectionSort {
	static final int SIZE = 10;
	
	public static void selectionSort(int[] m) {
		int temp;
		int index;
		
		for(int i = 0; i<m.length;i++){
			index = i;
			
			for(int j = i+1;j<m.length;j++){//找出最小数的index
				if(m[j]<m[index]){
					index = j;
				}
				
			}
			if(index !=i){//交换位置
				temp = m[i];
				m[i]=m[index];
				m[index] = temp;
			}
			System.out.println("第" + (i+1) + "步排序结果：");
			for(int k = 0;k<m.length;k++){
				System.out.print( " " + m[k]);
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
		
		selectionSort(m);
		System.out.println("排序后数组为：");
		for(i=0;i<SIZE;i++){
			System.out.print(m[i]+ " ");
		}
		System.out.println("\n");

	}

	

}
