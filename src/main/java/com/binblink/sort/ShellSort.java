package com.binblink.sort;
/*
 * Shell排序：
 * 1.将有n个元素的数组分成n/2个数字序列，第一个数据和第n/2+1个数据为一对.....
 * 2.一次循环使每个序列对排好序
 * 3.然后，再变为n/4个序列，再次排序
 * 4.不断重复上述过程，随着序列减少为最后一个，就完成了整个排序。
 * 具有较高的效率。
 */
public class ShellSort {
	static final int SIZE = 10;
	
	public static void shellSort(int[] m) {
		int i,j,h;
		int r,temp;
		int x = 0;
		
		for(r=m.length/2;r>=1;r/=2){
			
			for(i=r;i<m.length;i++){
				temp=m[i];
				j=i-r;
				while(j>=0&&temp<m[j]){
					m[j+r]=m[j];
					j-=r;
				}
				m[j+r]=temp;
			}
			x++;
			System.out.println("第" + x + "步排序结果：");
			for( h = 0;h<m.length;h++){
				System.out.print( " " + m[h]);
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
		
		shellSort(m);
		System.out.println("排序后数组为：");
		for(i=0;i<SIZE;i++){
			System.out.print(m[i]+ " ");
		}
		System.out.println("\n");
	}

	

}
