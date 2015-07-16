package heroi;

import java.util.ArrayList;
import java.util.List;

class XibFile {

	private final String filename;
	
	private final List<XibEntry> entries = new ArrayList<XibEntry>();
	
	private final List<String> allIds = new ArrayList<String>();
	
	XibFile(String filename) {
		this.filename = filename;
	}
	
	List<XibEntry> getEntries() {
		return this.entries;
	}
	
	void add(XibEntry entry) {
		entries.add(entry);	
	}
	
	void print() {
		System.out.println("Parsing file: " + filename);
	}
}

