package com.binblink.javase.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	
	public static void main(String[] args) throws IOException {
		
		//gsm();
		
		demo();
		
	}

	
	
	/*
	 * Properties集合：通常用于以操作键值对形式存在的配置文件
	 * 特点：
	 * 1  该集合继承至HashTable,并且键、值都是字符串类型
	 * 2 集合中的数据可以保存在流中，也可以从流中取出。
	 * 
	 */
	
	private static void demo() throws IOException {
		
		Properties p = new Properties();
		
		p.setProperty("lisa", "35");
		p.setProperty("asd", "123");
		p.setProperty("gr", "23");
		p.setProperty("hjg", "56");
		
		FileOutputStream fos = new FileOutputStream("info.txt");
		p.store(fos ,"name + age");
		
		fos.close();
	}



	private static void gsm() {
		
		Properties p = new Properties();
		
		p.setProperty("lisa", "35");
		p.setProperty("asd", "123");
		p.setProperty("gr", "23");
		p.setProperty("hjg", "56");
		
		Set<String> names = p.stringPropertyNames();
		
		for(String name : names){
			String value = p.getProperty(name);
			System.out.println(name + ":" + value);
		}
	}
	
	
}
