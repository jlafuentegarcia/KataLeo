package es.decide.kataleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class KataTest {
	
	@Test
	public void fireText(){
		
		List<String> linesExpected = readFile("/outGrande.txt");
		Integer linesForced =linesExpected.size();
		
		Long t1 = System.currentTimeMillis();
		List<String> linesProcessedMethod1 = processLines(readFile("/studious_student.in"));
		System.out.println("Method1 time: "+ (System.currentTimeMillis()-t1)+"ms");
		
		for (int i = 0; i < linesForced; i++) {
			System.out.println(linesExpected.get(i)+"-"+ linesProcessedMethod1.get(i));
			Assert.assertEquals(linesExpected.get(i), linesProcessedMethod1.get(i));
		}
		
	}
	
	private List<String> processLines(List<String> readFile) {
		List<String> solution = new ArrayList<String>(); 
		readFile.remove(0);
		for (String string : readFile) {
			String outLine="";
			String[] words =string.split(" ");
			for (int i = 0; i < words.length; i++) {
				words[i] = words[i]+getzeros(words[i].length());
			}
			words[0]="";
			Arrays.sort(words);
			for (String listWord : Arrays.asList(words)) {
				outLine+=listWord;
			}
			solution.add(outLine.replace("z0", ""));
		}
		return solution;
	}

	private String getzeros(int length) {
		String zeros="";
		for (int i = 0; i < 10-length; i++) {
			zeros+="z0";
		}
		return zeros;
	}

	private List<String> processLines2(List<String> readFile) {
		return new ArrayList<String>();
	}

	private List<String> readFile(String fileName){
		List<String> lines = new ArrayList<String>();
		BufferedReader br = null;

		try {

			String sCurrentLine;
			
			InputStream stream = KataTest.class.getResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return lines;
	}

}
