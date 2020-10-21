package com.binblink.jvm;

/**
*
* @author binblink
* @Date 2020/10/22 1:53
* @version 1.0.0
* @Description java.lang.StackOverflowError
*
**/
public class TestStackDeep {
	private static int count = 0;

	public static void recursion() {
		count++;
		recursion();
	}

	public static void main(String[] args) {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of calling =" + count);
			e.printStackTrace();
		}

	}

}
