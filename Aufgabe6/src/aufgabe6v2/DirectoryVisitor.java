package aufgabe6v2;

import java.io.File;

public interface DirectoryVisitor {

	void enterDirectory(File dir);
	void leaveDirectory(File dir);
	void visitFile(File file);
}
