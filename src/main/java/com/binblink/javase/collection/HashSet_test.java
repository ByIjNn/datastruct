package com.binblink.javase.collection;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class HashSet_test {

	@Test
	public void fun1(){
		
		HashSet hs = new HashSet();
		
		hs.add("aa");
		hs.add("bb");
		hs.add("cc");
		
		Iterator it = hs.iterator();
		System.out.println(hs);
		
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}
