package com.binblink.javase.io.File;

import java.io.File;
/*
 * 删除文件，深度遍历后删除！
 */

public class FileDelete {
	
	public static void main(String[] args) {
		
		File dir = new File("G:\\workspace\\java8\\src");
		
		delete(dir);
	}

	
	private static void delete(File dir) {
		
		File[] files =	dir.listFiles();
		
		for(File file : files){
			
			if(file.isDirectory()){
				delete(file);
			}else{
				
				System.out.println(file.delete());
			}
		}
		System.out.println(dir.delete());
		
	}
	
	
	
}
