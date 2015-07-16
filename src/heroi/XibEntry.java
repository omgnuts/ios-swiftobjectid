package heroi;

class XibEntry {
	
	private final String fullTag; // for use later versions

	private final String tag; // for use in later versions

	private final String oldId;
	
	private final String newId;
	
	XibEntry(String fullTag, String tag, String oldId, String newId) {
		this.fullTag = fullTag;
		this.oldId = oldId;
		this.tag = tag;
		this.newId = newId;
	}
	
	String getOldId() {
		return this.oldId;
	}
	
	String getNewId() {
		return this.newId;
	}
	
	void print() {
		System.out.println(oldId + " : " + newId);
	}
}
