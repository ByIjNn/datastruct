package com.binblink.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
	
	//字节流的简单操作
	public static void output() throws Exception{
		
		FileOutputStream out = new FileOutputStream("demo.txt");
		
		out.write("askdhaksdh".getBytes());
		
		FileInputStream in = new FileInputStream("demo.txt");
		
		byte[] b = new byte[1024];
		
		int len = 0;
		
		System.out.println(in.available());
		
		while((len = in.read(b))!= -1 ){
			
			System.out.println(new String(b,0,len));
		}
		
				
	}
	
	public static void copy_1() throws Exception{
		
		FileInputStream in = new FileInputStream("Some Like It Hot.mp3");
		
		FileOutputStream out = new FileOutputStream("银魂主题曲copy_1.mp3");
		
		byte[] b = new byte[1024];//该数组起到自定义的缓冲区的作用
		
		int len = 0;
		
		while((len = in.read(b)) != -1){
			
			out.write(b, 0, len);
		}
		
		out.close();
		in.close();
	}
	
	public static void copy_2() throws Exception{
		
		FileInputStream in = new FileInputStream("Some Like It Hot.mp3");
		BufferedInputStream bufin = new BufferedInputStream(in);
		
		FileOutputStream out = new FileOutputStream("银魂主题曲copy_2.mp3");
		BufferedOutputStream outbuf = new  BufferedOutputStream(out);
		
		byte[] b = new byte[1024];
		
		int len = 0;
		
		while( (len = bufin.read()) != -1){
			
			outbuf.write(len);
			outbuf.flush();
		}
		
		outbuf.close();
		bufin.close();
	}
	
	//不建议使用，因为如果文件过大，创建数组时效率不高，也可能造成数组溢出
	public static void copy_3() throws Exception{
		
		FileInputStream in = new FileInputStream("Some Like It Hot.mp3");
		
		FileOutputStream out = new FileOutputStream("银魂主题曲copy_3.mp3");
		
		byte[] b = new byte[in.available()];//该数组起到自定义的缓冲区的作用
		
		in.read(b);
		out.write(b);
		
		out.close();
		in.close();
		
	}
	
	//原始的，读一个写一个,速度非常慢,万万不能用
	public static void copy_4() throws Exception{
		
		FileInputStream in = new FileInputStream("Some Like It Hot.mp3");
		
		FileOutputStream out = new FileOutputStream("银魂主题曲copy_4.mp3");
		
		
		int len = 0;
		
		while((len = in.read()) != -1){
			
			out.write(len);
		}
		
		out.close();
		in.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		// output();
		
//		copy_1();
//		copy_2();
//		copy_3();
		copy_4();
		
		
	}
}
