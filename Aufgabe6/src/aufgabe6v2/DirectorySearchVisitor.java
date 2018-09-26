package aufgabe6v2;

import java.io.File;
import java.util.*;


public class DirectorySearchVisitor implements DirectoryVisitor {
	private String extension;
	private List<String> searchList;
	
	public void setExtension(String s) {
		this.extension = s; // setzen von setExtension
	}
	
	public void clearSearchList() {
		searchList.clear();
	}
	
	public List<String> getSearchList() {
		return this.searchList;
	}

	@Override
	public void enterDirectory(File dir) {		
	}

	@Override
	public void leaveDirectory(File dir) {		
	}

	@Override
	public void visitFile(File file) {
		if (file.getName().endsWith(extension)){
			searchList.add(file.getName());
		}
	
	}
	
}


