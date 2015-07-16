package heroi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchAndDestroy implements Runnable {

	private final String path;
	
	private final List<XibFile> xibs = new ArrayList<XibFile>();
	
	SearchAndDestroy(String path) {
		this.path = path;
	}
	
	@Override
	public void run() {
	
		File dir = new File(path);
		String[] extensions = new String[] { "xib" };
		
		try {
			final List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
			
			
			for (File file : files) {
				FileInputStream inputStream = new FileInputStream(file.getCanonicalPath());
				try {
			        String content = IOUtils.toString(inputStream);
			        inputStream.close();
			        
			        final String nFile = file.getCanonicalPath() + "o";
			        int count = 0; 
			        String newFile;
			        
			        do {
			        	newFile = nFile + "_" + count++;
			        } while (new File(newFile).exists());
			        
			        FileUtils.copyFile(new File(file.getCanonicalPath()),
			        		new File(newFile));
			        content = findAndDestroy(file.getCanonicalPath(), content, baddpatt);
			        if (content != null) {
			    		FileUtils.writeStringToFile(file, content);
			        }
			    } finally {
			        if (inputStream != null) inputStream.close();
			    }
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final Pattern baddpatt = Pattern.compile(
			"(\\w{3}-\\w{2}-\\w{3}|XXX-XX-XX)", Pattern.DOTALL);
//			"(^\\w{3}-?\\w{2}-?\\w{3}$|^XXX-XX-XXX$)", Pattern.DOTALL);
	
	private static String findAndDestroy(final String filename, final String content, Pattern pattern) {
		if (content != null) {
			Matcher matcher = pattern.matcher(content);
			if (matcher.find()) {
				return cleanXib(filename, content);
			}
		}
		return null;
	}
	
	private static String cleanXib(final String filename, String content) {
		
		final Document jdoc = Jsoup.parse(content);
		Elements elems = jdoc.select("[id]");
		
		Set<String> keys = new HashSet<String>();
		XibFile xibf = new XibFile(filename); 
		
		for (Element elem : elems) {
			String id = elem.attr("id");
			
			if (baddpatt.matcher(id).find()) { // badid
				String tag = elem.tagName();
				String data = elem.data();
				
				int count = 1;
				String newId;
				do {
					newId = tag + count++;
				} while (keys.contains(newId));
				
				XibEntry entry = new XibEntry(data, tag, id, newId);
				xibf.add(entry);
				keys.add(newId);
				
				entry.print();
			} else {
				keys.add(id);
			}
		}
		
		for (XibEntry entry : xibf.getEntries()) {
			content = content.replace(entry.getOldId(), entry.getNewId());
		}
		
		return content;
		
	}
	
}
