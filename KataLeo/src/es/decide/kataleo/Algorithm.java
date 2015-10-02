package es.decide.kataleo;

import java.util.List;

public class Algorithm {
	
	public String getResult(Input input) {
		StringBuilder builder = new StringBuilder();
		
		List<String> inputData = input.getDataCopy(); 
		
		while (!inputData.isEmpty()) {
			String res = selectNext(inputData, 0);
			builder.append(res);

			inputData.remove(res);
		}
		
		
		return builder.toString();
	}
	
	private String selectNext(List<String> unSelected, int selectedId) {
		String selected = unSelected.get(selectedId);
		
		for ( int s = selectedId+1; s < unSelected.size(); s++ ) {
			String candidate = unSelected.get(s);
			if ( candidate.length() >= selected.length() && 
				 candidate.substring(0, selected.length()).equals(selected) ) {
				
				String rightSide = candidate.substring(selected.length());
				if ( rightSide.compareTo(selected) < 0 ) { 
					selected = rightSide;
					selected = selectNext(unSelected, s);
				}
			} else {
				break;
			}
		}
		
		return selected;
	}
}
