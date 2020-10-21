package com.binblink.javase.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Outputdemo();
		Inputdemo();
		
	}
	
	
	public static void Outputdemo() throws FileNotFoundException, IOException{
		
		ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
		
		Person p = new Person();
		p.setName("小明");
		p.setAge(18);
		p.setSex("男");
		p.setAddress("xzxczxc");
		
		oos.writeObject(p);
		
		oos.close();
	}
	
	public static void Inputdemo() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("object.txt"));
		
		Person p =  (Person) ooi.readObject();
		
		System.out.println(p);
	}
}
