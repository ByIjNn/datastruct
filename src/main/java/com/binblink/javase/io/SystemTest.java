package com.binblink.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SystemTest {
	
	public static void main(String[] args) throws IOException {
		
//		input();
		transform();
		
	}
	
	public static void  input() throws IOException{
		
		InputStream in =  System.in;
		
		int a = in.read();
		System.out.println(a);
	}
	
	//键盘录入
	public static void transform() throws IOException{
		
		 
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufo = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		
		while((line = bufr.readLine()) != null){
			
			bufo.write(line);
			bufo.newLine();
			bufo.flush();
		}
		
	
		
	}
}
