package com.org.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite {

	public static void main(String[] args) throws IOException,FileNotFoundException {
		FileReader fr=new FileReader("D:\\BCITS\\MyText.txt");
		BufferedReader br=new BufferedReader(fr);
		FileWriter fw= new FileWriter("D:\\BCITS\\MyText45.txt");
		BufferedWriter bw=new BufferedWriter(fw); 
		String s=br.readLine();
		bw.write(s);
		bw.flush();
		bw.close();

	}

}
 