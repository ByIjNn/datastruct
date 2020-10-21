package com.binblink.javase.io.File;

import java.io.File;
import java.io.FilenameFilter;

public class FilterType_txt implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		
	    System.out.println(dir +"--" +name);	
		
		return name.endsWith(".xml");
	}

}
