package heroi;

import java.io.File;

public final class Main {

	enum Action {
		SET_PATH("--path"),
		REQ_HELP("--help");
		
		private final String action;
		
		private Action(String arg) {
			this.action = arg;
		}
		
		static Action find(String action) {
			
			if (!action.startsWith("--")) return null;

			if (action.equals(SET_PATH.action)) {
				return Action.SET_PATH;
			} else if (action.equals(REQ_HELP.action)) {
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
			while (c < args.length) {
				Action action = Action.find(args[c++]);
				
				if (action == null) {
					printHelp();
					return;
				}
				
				if (action.equals(Action.SET_PATH)) {
					if (c < args.length) {
						path = args[c++];
					}
				} else if (action.equals(Action.REQ_HELP)) {
					printHelp();
					return;
				}						
			}
		}
		
		start(path);
	}
	
	private static void start(String path){

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
		StringBuilder sb = new StringBuilder();
		sb.append("\nusage: readoi [--path <path>] [--help]" + "\n\n");
		sb.append("Or, just use the default in your project root: \ne.g. java -jar readoi\n\n");
		
		sb.append("This program checks for the crypto object-ids in XCODE projects \n");
		sb.append("and replaces them with human readable references. \n");
		sb.append("The original files are automatically backed up with extension *.old \n");
		sb.append("which can be included in .gitignore if needed. \n");
		sb.append("Enjoy coding in XCODE and have a good day! \n");
		
		System.out.println(sb.toString());
	}

}
