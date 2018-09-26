// O. Bittel
// 13.4.2011

package aufgabe6v2;

import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class FileBrowserV2 {

	public static void main(String[] args) {
		File dir = new File("home//bjoernus//Schreibtisch"); 
		traverse (dir, new DirectoryPrintVisitor());
	}
		
	public static void traverse (File dir, DirectoryVisitor visitor) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				visitor.enterDirectory(f);
				traverse(f, visitor);
				visitor.leaveDirectory(f);
			} else {
				visitor.visitFile(f);
			}
		}
	}
}
