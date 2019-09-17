package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SaveResult {
	
	private FileOutputStream simple = null;
	private FileOutputStream complex = null;
	
	public SaveResult() throws IOException {
		// TODO Auto-generated constructor stub
		simple = new FileOutputStream("files/result/simple_result.txt");
		complex = new FileOutputStream("files/result/complex_result.txt");
	}
	
	public void prepareSimple() throws IOException {
		String a = "Entities";
		String b = "Relations";
		String s = String.format("%-10s |\t %-10s |\t1    |\t2    |\t3    |\t4    |\t5    |\t6    |\t7    |\t8    |\t9    |\t10   |\t\n", a,b);
		s += "--------------------------------------------------------------------------------------------------------------\n";
		byte data[] = s.getBytes();
		simple.write(data);
	}

	public void prepareComplex() throws IOException {
		String a = "Entities";
		String b = "Relations";
		String s = String.format("%-10s |\t %-10s |\t1    |\t2    |\t3    |\t4    |\t5    |\t6    |\t7    |\t8    |\t9    |\t10   |\t\n", a,b);
		s += "--------------------------------------------------------------------------------------------------------------\n";
		byte data[] = s.getBytes();
		complex.write(data);
	}
	public void addSimple(List<Integer> result, int numOfEntities, int numOfRelations) throws IOException{
		String out = String.format("%-10d |\t %-10d |\t", numOfEntities, numOfRelations);
		for (Integer i: result) {
			out += String.format("%-5d|\t", i);
		}
		out += "\n";
		byte data[] = out.getBytes();
		simple.write(data);
	}
	
	public void addComplex(List<Integer> result, int numOfEntities, int numOfRelations) throws IOException{
		String out = String.format("%-10d |\t %-10d |\t", numOfEntities, numOfRelations);
		for (Integer i: result) {
			out += String.format("%-5d|\t", i);
		}
		out += "\n";
		byte data[] = out.getBytes();
		complex.write(data);
	}
	
	public void showResult() throws IOException {
		this.simple.close();
		this.complex.close();
		BufferedReader sim = new BufferedReader(new FileReader("files/result/simple_result.txt"));
		BufferedReader com = new BufferedReader(new FileReader("files/result/complex_result.txt"));
		System.out.println("Kết quả:");
		System.out.println("\n\n----SIMPLE----\n\n");
		String line;
		line = sim.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = sim.readLine();
		}
		System.out.println("\n\n----COMPLEX----\n\n");
		line = com.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = com.readLine();
		}
		sim.close();
		com.close();
	}
}
