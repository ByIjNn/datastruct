package com.binblink.javase.io.File;

import java.io.File;

public class FileTest {
	
	//File类的构造方法和一些关键字段
	public static void  constructorDem(){
		
		File f1 = new File("C:\\kk.txt");//将一个已经存在或者不存在的文件或目录封装成File对象
		
		File f2 = new File("C:\\","b.txt");//指定系统路径下创建
		
		File f3 = new File("c:\\");
		
		File f4 = new File(f3,"c.txt");
		
		File f5 = new File("c:" + File.separator + "abc" + File.separator + "d.txt");
		System.out.println(f5);
		
		
		
	}
	public static void main(String[] args) {
		
		constructorDem();
		System.out.println(System.getProperty("file.separator"));
	}

}
