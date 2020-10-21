package com.binblink.javase.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SplitFileDemo {
	
	private static final int SIZE = 1024*1024;

	public static void main(String[] args) throws IOException {
		
		File file = new File("Some Like It Hot.mp3");
		splitFile( file);
	}
	
	/*
	 * 文件切割！
	 */
	private static void splitFile(File file) throws IOException   {
		
		FileInputStream input = new FileInputStream(file);
		
		byte[] buf = new byte[SIZE];
		
		FileOutputStream out = null;
		
		int count = 1;
		int len = 0;
		File dir = new  File("partfile");
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		while((len = input.read(buf)) != -1){
			
			
			out = new FileOutputStream(new File(dir, (count++) + ".part"));
			out.write(buf, 0, len);
			
		}
	
		out.close();
		input.close();
	}
}
