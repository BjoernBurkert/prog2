package aufgabe11;

import javax.swing.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;


public class TelefonBuchMenuBar extends JMenuBar implements ActionListener {

	private JMenuBar menuBar;
	private JMenu datei;
    private TelefonBuch telBuch;
    private JMenuItem lesen;
    private JMenuItem speichern;
    private JMenuItem beenden;
    
    
    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;
        
        menuBar = new JMenuBar();
        
        datei = new JMenu("Datei");
        
        lesen = new JMenuItem("TelefonBuch lesen...");
        lesen.addActionListener(this);
        speichern = new JMenuItem("TelefonBuch speichern ...");
        speichern.addActionListener(this);
        beenden = new JMenuItem("TelefonBuch beenden");
        beenden.addActionListener(this);
        
        datei.add(lesen);
        datei.add(speichern);
        datei.addSeparator();
        datei.add(beenden);
         
        menuBar.add(datei);
        
        this.add(menuBar);
    }

    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	final JFileChooser fc = new JFileChooser();
    	File file;
    	
    	if (source == lesen) {
    		fc.showOpenDialog(null);
    		if((file = fc.getSelectedFile()) != null) {
    			telBuch.read(file);
    		} else {
    			return;
    		}
    	} else if (source == speichern) {
    		fc.showSaveDialog(null);
    		if ((file = fc.getSelectedFile()) != null) {
    			telBuch.save(file);
    		} else {
    			return;
    		}
    	} else if (source == beenden) {
			int input = JOptionPane.showConfirmDialog(beenden, "Wollen Sie wirklich beenden?");
			if(input == 0)
			{
				System.exit(input);
			}
    	}
    }
}