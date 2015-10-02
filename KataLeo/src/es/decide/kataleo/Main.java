package es.decide.kataleo;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Input> input = Reader.ReadFile(args[0]);

		Algorithm alg = new Algorithm();
		
		for ( Input i : input ) {
			String res = alg.getResult(i);
			System.out.println(res);
		}
	}

}
