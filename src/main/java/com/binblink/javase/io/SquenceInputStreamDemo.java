package com.binblink.javase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;



public class SquenceInputStreamDemo {
	
	public static void main(String[] args) throws IOException {
		
//		Vector<FileInputStream> v = new Vector<FileInputStream>();
//		Vector由于效率低下，所以已经过时
//		v.add(new FileInputStream("1.txt"));
//		v.add(new FileInputStream("2.txt"));
//		v.add(new FileInputStream("3.txt"));
//		v.add(new FileInputStream("4.txt"));
		
		ArrayList<FileInputStream> a = new  ArrayList<FileInputStream>();
		
		//final Iterator<FileInputStream> in =  a.iterator();
		File dir = new File("partfile");
		
		for(int i = 1;i<=3;i++){
			a.add(new FileInputStream(new File(dir,i + ".part")));
			
		}
		
		Enumeration<FileInputStream> en = Collections.enumeration(a);
//	
//		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
//			
//			@Override
//			public FileInputStream nextElement() {
//				// TODO Auto-generated method stub
//				return in.next();
//			}
//			
//			@Override
//			public boolean hasMoreElements() {
//				// TODO Auto-generated method stub
//				return in.hasNext();
//			}
//		};
		
		SequenceInputStream sqe = new SequenceInputStream(en);
		
		FileOutputStream out = new FileOutputStream("合并.mp3");
		
		byte[] b = new byte[1024];
		
		int len = 0;
		
		while((len = sqe.read(b)) != -1){
			
			out.write(b, 0, len);
		}
		
		out.close();
		sqe.close();
	}
}
