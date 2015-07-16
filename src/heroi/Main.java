package heroi;

import java.io.File;

public final class Main {

	enum Action {
		SET_PATH("path"),
		REQ_HELP("help");
		
		private final String action;
		
		private Action(String arg) {
			this.action = arg;
		}
		
		static Action find(String val) {
				
			if (!val.startsWith("--")) return null;
			
			final String action = val.replace("--", "");

			if (action.equals("path")) {
				return Action.SET_PATH;
			} else if (action.equals("help")) {
				return Action.REQ_HELP;
			} else {
				return null;
			}
		}
	}
	
	public static void main(String[] args) {
		
		String path = null;
		
		if (args != null && args.length > 0) {
			int c = 0;
			
			while ((c+1) < args.length) {
				Action action = Action.find(args[c++]);
				
				if (action == null) {
					printHelp();
					throw new RuntimeException("Wrong parameter input!");
				}
				
				if (action.equals(Action.SET_PATH)) {
					path = args[c++];
				} else if (action.equals(Action.REQ_HELP)) {
					printHelp();
				}						
			}
		}
		
		if (path != null) {
			File pathdir = new File(path);
			if (!pathdir.exists()) {
				throw new RuntimeException("Path not found!");
			}
		} else {
			path = System.getProperty("user.dir");
		}
		
		new SearchAndDestroy(path).run();
		
	}
	
	private static void printHelp() {
		
	}

}
