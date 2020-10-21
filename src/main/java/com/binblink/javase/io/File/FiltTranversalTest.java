package com.binblink.javase.io.File;

import java.io.File;
/*
 * 深度遍历文件夹
 */

public class FiltTranversalTest {
	
	public static void main(String[] args) {
		
		File dir = new File("G:\\遍历文件夹测试");
		
		tranverse(dir, 0);
	}

	private static void tranverse(File dir, int i) {
		
		System.out.println(getSpace(i) +dir.getName());
		
		File[] files = dir.listFiles();
		
		i++;
		for(File f : files){
			
			if(f.isDirectory()){
				
				tranverse(f,i);
			}else{
				System.out.println(getSpace(i) + f.getName());
			}
		}
		
	}

	private static String getSpace(int k) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int l = 0;l<=k;l++ ){
			
			sb.append("    ");
		}
		
		
		return sb.toString();
	}

	
	
}
