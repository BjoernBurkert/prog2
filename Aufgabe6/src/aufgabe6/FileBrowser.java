// O. Bittel
// 13.4.2011

package aufgabe6;

import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class FileBrowser {
	private static List<String> list = new LinkedList<>();

	public static void main(String[] args) {
		File dir = new File("C:/Users/Björn/Desktop/test");

//		File[] files = dir.listFiles();
//		for (File f : files) {
//			if (f.isDirectory())
//				System.out.println("Verzeichnis: " + f.getParent() + "/" + f.getName());
//			else
//				System.out.println("Datei: " + f.getParent() + "/" + f.getName());
//		}

		System.out.println("\n\n Test dirPrint \n\n");
		dirPrint(dir);
		System.out.println("\n\n Test dirSearch \n\n");
		List<String> list = new LinkedList<>();
		dirSearch(dir, ".java", list);
		System.out.println(list);
	}

	public static void dirPrint(File file) {
		
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println("Verzeichnis: " + f.getParent() + "/" + f.getName());
				dirPrint(f);
			} else {
				System.out.println("  Datei: " + f.getParent() + "/" + f.getName());
			}
		}

	}
	public static void dirSearch(File file, String extension, List<String> l) {
		File[] files = file.listFiles();	
		for (File f : files) {
				if (f.isDirectory()) {
					dirSearch(f, extension, l);
				} else {
					if (f.getName().endsWith(extension)) {				
						l.add(f.getName());
					}
				}
			}
			
		}
	}


