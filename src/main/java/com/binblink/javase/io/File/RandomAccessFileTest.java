package com.binblink.javase.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
		
	public static void main(String[] args) throws IOException {
		
		writeFile();
		readFiele();
	}

	private static void readFiele() throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("random.txt","r");
		
		byte[] b = new byte[4];
		
		raf.seek(1*8);
		
		raf.read(b);
		
		String name = new String(b);
		int age = raf.readInt();
		
		System.out.println(name);
		System.out.println(age);
		
		raf.close();
		
	}

	private static void writeFile() throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("random.txt","rw");
		
		raf.write("张三".getBytes());
		raf.writeInt(98);
		raf.write("李四".getBytes());
		raf.write(97);
		
		raf.close();
	}
	
	
}
