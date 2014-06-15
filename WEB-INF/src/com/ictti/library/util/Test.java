package com.ictti.library.util;

public class Test {
	public static void main(String[]args){
		String user="ps9-ayeaye";
		 String[] temp;
		 String delimiter = "-";
		 temp=user.split(delimiter);
		boolean t=user.contains(delimiter);
		System.out.println(t);
		/* for(int i=0;i<temp.length;i++){
			 System.out.println(temp[0]);
		 }*/
		String st="";
		st+=temp[0];
		System.out.println(st);
		
	}

}
