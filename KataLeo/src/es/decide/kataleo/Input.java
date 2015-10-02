package es.decide.kataleo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
	private String[] items;
	
	public Input(String[] items) {
		this.items = new String[items.length-1];
		System.arraycopy(items, 1, this.items, 0, items.length-1);		
		Arrays.sort(this.items);
	}
	
	public int getNbItems() {
		return items.length;
	}
	
	public String get(int item) {
		return items[item];
	}
	
	public List<String> getDataCopy() {
		return new ArrayList<String>(Arrays.asList(items));
	}
}
