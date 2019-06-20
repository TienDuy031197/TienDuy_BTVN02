package com.btvn02;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = Calendar.getInstance().getTimeInMillis();
		
		Process process = new Process();
		process.readFile(Constant.PATH);
		process.sort();
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println(end - start);
	}

}
