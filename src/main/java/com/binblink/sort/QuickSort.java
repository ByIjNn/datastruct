package com.binblink.sort;

/*
 * 快速排序（quicksort）流程：
 * 1.首先设定一个分界值，通过该分界值将数组分成左右两部分。
 * 2.将大于等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分的所有元素都小于分界值，
 * 右边部分的所有元素都大于等于分界值。
 * 3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样，
 * 左边放置小值，右边放置大值。右侧数组数据同上。
 * 4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧数据排好序后，再递归排后右侧部分的顺序。当左右两个部分
 * 各个数据排序好后，整个数组的排序也就完成了。
 */
public class QuickSort {
	
	static final int SIZE = 18;
	static void quickSort(int[] arr,int left,int right){
		
		int f, t ;
		int rtemp,ltemp;
		
		rtemp = right;//右
		ltemp = left;
		f= arr[(left+right)/2];
		while(ltemp < rtemp){
			
			while(arr[ltemp] < f){
				++ltemp;
			}
			while(arr[rtemp] > f){
				--rtemp;
			}
			if(ltemp<=rtemp){
				t=arr[ltemp];
				arr[ltemp] = arr[rtemp];
					arr[rtemp] = t;
				--rtemp;
					++ltemp;
			}
		}
		if(ltemp == rtemp){
			ltemp++;
		}
		
		if(left < rtemp){
			quickSort(arr,left,ltemp-1);
		}
		if(ltemp < right){
			quickSort(arr,rtemp+1,right);
		}
	}
	
	public static void main(String[] args) {
		int[] shuzu = new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++){
			shuzu[i] = (int) (100+Math.random()*(100+1));
		}
		
		System.out.println("排序前的数组为：");
		
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i] + " ");
		}
		
		System.out.print("\n");
		
		quickSort(shuzu, 0, SIZE-1);
		
		System.out.println("排序后的数组为：");
		
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i] + " ");
		}
		
		System.out.print("\n");
	}

}
