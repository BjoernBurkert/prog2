package aufgabe6v2;

import java.io.File;

public class DirectoryPrintVisitor implements DirectoryVisitor{
	
	int einrueckung = 0;
	
	@Override
	public void enterDirectory(File dir){
		einrueckung++;
		for(int i = 0; i < einrueckung; i++){
			System.out.print("  ");
		}
		System.out.print("Verzeichnis: " + dir.getName() + "\n");
	}
	
	@Override
	public void leaveDirectory(File file){
		einrueckung--;
	}
	
	@Override
	public void visitFile(File file){
		einrueckung++;
		for(int i = 0; i < einrueckung; i++){
			System.out.print("Verzeichnis: " + file.getName() + "\n");
			einrueckung--;
		}
	}

}
