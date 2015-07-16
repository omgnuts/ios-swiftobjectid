package heroi;

import java.util.ArrayList;
import java.util.List;

public class XibFile {

	private final String filename;
	
	private final List<XibEntry> entries = new ArrayList<XibEntry>();
	
	private final List<String> allIds = new ArrayList<String>();
	
	XibFile(String filename) {
		this.filename = filename;
	}
	
	public List<XibEntry> getEntries() {
		return this.entries;
	}
	
	public void add(XibEntry entry) {
		entries.add(entry);	
	}
}

