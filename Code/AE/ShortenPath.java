import java.util.*;

class ShortenPath {
  public static String shortenPath(String path) {
    String[] pathArray = path.split("/");
		Stack<String> shortPathStack = new Stack<>();
		
		boolean isRootPath = false;
		if (path.charAt(0) == '/') {
			isRootPath = true;
			shortPathStack.push("");
		}
		
		for(String dirEntry : pathArray) {
			switch(dirEntry) {
				case "":
				case ".":
					continue;
				case "..":
					boolean isEmptyStack = shortPathStack.empty();
					if (isRootPath) {
						if (!shortPathStack.peek().equals("")) {
							shortPathStack.pop();
							continue;
						}
					} 
					
					else {
						if (isEmptyStack || shortPathStack.peek().equals("..")) {
							shortPathStack.push("..");
							continue;
						}
						shortPathStack.pop();
					}
					continue;
				default:
					shortPathStack.push(dirEntry);
			}
		}
    if (shortPathStack.size() == 1 && shortPathStack.peek().equals("")) return "/";       
		return String.join("/", shortPathStack);
	}
}
