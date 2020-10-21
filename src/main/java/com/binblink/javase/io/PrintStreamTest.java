package com.binblink.javase.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamTest {
	
	public static void main(String[] args) throws IOException {
		
		PrintStreamDemo();
		PrintWriterDemo();
	}

	private static void PrintWriterDemo() throws IOException {
		
		BufferedReader buread = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out,true);
		
		String line = null ;
		
		while((line = buread.readLine()) != null){
			
			if("over".equals(line)) 
				break;
			out.println(line);
		}
		
		out.close();
		
	}

	private static void PrintStreamDemo() throws FileNotFoundException {
		
		PrintStream ps = new PrintStream("a.txt");
		
		ps.write(97);//输出a
		
		ps.print(97);//保持数据的表示形式,输出97
		ps.close();
	}
}
