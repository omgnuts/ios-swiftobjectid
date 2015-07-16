package heroi;

public class XibEntry {
	
	private final String fullTag;
	
	private final String oldId;
	
	private final String tag;

	private final String newId;
	
	public XibEntry(String fullTag, String tag, String oldId, String newId) {
		this.fullTag = fullTag;
		this.oldId = oldId;
		this.tag = tag;
		this.newId = newId;
	}
	
	public String getOldId() {
		return this.oldId;
	}
	
	
	public String getNewId() {
		return this.newId;
	}
	
	public void print() {
		System.out.println(tag + " : " + oldId + " : " + newId);
	}
}
