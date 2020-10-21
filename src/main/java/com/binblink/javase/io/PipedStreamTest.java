package com.binblink.javase.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest {
	
	public static void main(String[] args) throws IOException {
		
		PipedInputStream input = new PipedInputStream();
		
		PipedOutputStream output = new PipedOutputStream();
		input.connect(output);
		
		new Thread(new Input(input)).start();
		new Thread(new Output(output)).start();
	}
}	
	
 class Input implements Runnable{

	private PipedInputStream in ;
		
		Input(PipedInputStream in){
			this.in = in;
		}
		
		@Override
		public void run() {
			
			try {
				
				byte[] b = new byte[1024];
				
				int len = in.read(b);
				String s = new String(b,0,len);
				System.out.println(s);
			} catch (Exception e) {
				
			}
		}
		
	}
	
 class Output implements Runnable{
		
		private PipedOutputStream output;
		
		Output(PipedOutputStream output){
			
			this.output = output;
		}
		
		@Override
		public void run() {
			try {
				output.write("管道来了！快来围观！".getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}


