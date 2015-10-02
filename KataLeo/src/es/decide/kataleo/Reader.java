package es.decide.kataleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	public static List<Input> ReadFile(String fileName) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Reader.class.getResourceAsStream("/" + fileName)));
		
		String header = bufferedReader.readLine();
		Integer nbRows = Integer.parseInt(header);

		List<Input> res = new ArrayList<Input>();
		
		for ( int i = 0; i < nbRows; i++ ) {
			String line = bufferedReader.readLine();
			
			String[] items = line.split(" ");
			
			Input input = new Input(items);
			
			res.add(input);
		}
		
		return res;
	}
}
