package com.binblink.javase.io.File;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


public class FileMethodTest {
	
	public static void main(String[] args) throws IOException {
		
//		getDemo();
//		createAndDelete();
//		isDemo();
//		
		fileFilter();
		
	}
	
	

	/*
	 * File类的常用方法
	 * 1. 获取
	 *   获取文件名
	 *   获取文件路径
	 *   获取文件大小
	 *   获取文件修改时间
	 *  
	 *  
	 */
	
	public static void getDemo(){
		
		File file = new File("demo.txt");
		
		String name = file.getName();//获取文件名称
		String absolutePath = file.getAbsolutePath();//获取绝对路径 ，对于系统而言完整的路径
		String path = file.getPath();//相对路径：相对与当前路径来说，即相对于JavaIo文件夹下的路径
		
		long l = file.length();//文件大小
		
		long time = file.lastModified();
		
		Date date = new Date(time);
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		
		String str_time = dateFormat.format(date);
		
		System.out.println(name);
		System.out.println(absolutePath);
		System.out.println(path);
		System.out.println(l);
		System.out.println(str_time);
		
		
	}
	
	/*
	 * 2 创建和删除
	 */
	
	public static void createAndDelete() throws IOException{
		
		File file = new File("file.txt");
		
		//boolean b = file.createNewFile();//创建新文件，前提改文件不存在！
											//若存在则不创建并抛出IOException!注意和输入流不一样!
		
		//boolean b =file.delete();
		//System.out.println(b);
		
		File f = new File("asd\\as\\a\\d\\s");
		
		f.mkdirs();//创建文件夹
		
		f.delete();//删掉最底层文件，因为创建多级目录实际上是创建最后一级的文件夹，前面的只是父路径罢了
		
		//f.delete();
		
	}
	
	/*
	 * 3 判断
	 * 
	 */
	public static void isDemo(){
		
		File f = new File("demo.txt");
		
		boolean b = f.exists();
	   
		
		File c = new File("C:\\");
		
		String[] names = c.list();
		
		for(String name:names){
			
			System.out.println(name);
		}
	}
	
	/*
	 * 过滤器功能
	 */
	public static void fileFilter(){
		
		File dir = new File("D:\\");
		
		String[] names = dir.list(new FilterType_txt());
		
		
		
		for(String name:names){
			
			System.out.println(name);
		}
		
	}
}
