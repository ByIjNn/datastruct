package com.binblink.sort;

/*堆排序：堆排序的关键是构造堆结构，即是构造一个完全二叉树。每个节点应满足条件：若升序，则父节点大于或等于左右子节点
 * 的数据，若降序则反之。在这里选择升序，则根节点为最大值。堆排序需要反复两个步骤：构造堆结构和堆排序输出。
 *“筛”运算来调整节点数据，以满足堆结构条件。
 *“筛”运算：从最底层的父节点开始，比较其左右子节点，选取较大的值与父节点比较，若大于父节点，则该子节点与父节点交换。其他
 *节点也是如此，	知道所有父节点均大于子节点的值。
 *排序输出：构造堆结构完成后，取最底层的节点，替换出根节点（最大值），将根节点保存至数组的最后位置。再进行构造堆结构，
 *排序输出。如此反复，知道最后两个数据比较完毕。排序也完成了。
 * 
 */

public class HeapSort {
	
	static final int SIZE = 10;
	
	static void heapSort(int a[],int n){
		
		int i,j,h,k;
		int t;
		
		for(i=n/2-1;i>=0;i--){
			
			while(2*i+1<n){
				
				j=2*i+1;
				
				if((j+1)<n){
					
					if(a[j]<a[j+1])
						j++;
				}
				if(a[i]<a[j]){
					t= a[i];
					a[i] = a[j];
					a[j] = t;
					i=j;
				}
				else{
					break;
				}
			}
		}
		
		System.out.print("原数据构成的堆：");
		for(h=0;h<n;h++){
			System.out.print(" " + a[h]);
		}
		System.out.print("\n");
			
		for(i=n-1;i>0;i--){
				
			t = a[0];
			a[0] = a[i];
			a[i] = t;
			k = 0;
			while(2*k+1<i){
				j=2*k+1;
				if((j+1)<i){
					if(a[j]<a[j+1]){
						j++;
					}
				}
				if(a[k] < a[j]){
						
					t = a[k];
					a[k] = a[j];
					a[j] = t;
					k=j;
				}
				else{
					break;
				}
			}
				
			System.out.print("第" + (n-i) + "步排序结果：");
			for(h=0;h<n;h++){
				System.out.print(" " + a[h]);
			}
			System.out.print("\n");
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
		
		heapSort(shuzu, SIZE);
		
		System.out.println("排序后的数组为：");
		
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i] + " ");
		}
		
		System.out.print("\n");
	}
}


