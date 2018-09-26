package aufgabe11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.LinkedList;
import java.util.List;

public class TelefonBuchSuchenLoeschenPanel extends JPanel implements ActionListener {

    private TelefonBuch telBuch;
    private JTextField tfSuchenName;
    private JTextField tfSuchenZusatz;
    private JTextArea ausgabeTextFeld;
    private JButton buttonAnwenden;
    String[] optionen = {"Exakte Suche", "Prefix-Suche", "Löschen"};
    private JComboBox suchOptionen;

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb) {
        telBuch = tb;
        Color white = new Color (255,255,255);
        
		JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));
		labelPanel.add(new JLabel("Name"));
		labelPanel.add(new JLabel("Zusatz"));
		
        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(new GridLayout(2, 1)); 
        tfSuchenName = new JTextField("", 20);
        textFieldsPanel.add(tfSuchenName);
        tfSuchenZusatz = new JTextField("", 20);
        textFieldsPanel.add(tfSuchenZusatz);
        
        JPanel test = new JPanel();
        JPanel test2 = new JPanel();
        suchOptionen = new JComboBox(optionen);
        suchOptionen.addActionListener(this);
        suchOptionen.setSelectedIndex(1);
        suchOptionen.setPreferredSize(new Dimension(150,26));
        test2.add(suchOptionen);
        buttonAnwenden = new JButton("Anwenden");
        buttonAnwenden.addActionListener(this);
        test.add(test2);
        test.add(buttonAnwenden);
        
        
        JPanel suchenLoeschenPanel = new JPanel();
        Border border = BorderFactory.createTitledBorder("Suchen/Loeschen");
        suchenLoeschenPanel.setBorder(border);
        suchenLoeschenPanel.setLayout(new BoxLayout(suchenLoeschenPanel, BoxLayout.LINE_AXIS));
        suchenLoeschenPanel.setPreferredSize(new Dimension(650,75));
        suchenLoeschenPanel.add(labelPanel);
        suchenLoeschenPanel.add(textFieldsPanel);
        suchenLoeschenPanel.add(test);
        
        
        JPanel ausgabePanel = new JPanel();
        Border border2 = BorderFactory.createTitledBorder("Ausgabe");
        ausgabePanel.setBorder(border2);
        ausgabePanel.setLayout(new BoxLayout(ausgabePanel, BoxLayout.LINE_AXIS));
        ausgabeTextFeld = new JTextArea("");
        ausgabeTextFeld.setSize(new Dimension(650,800));
        ausgabePanel.setPreferredSize(new Dimension(650,300));
        ausgabePanel.add(ausgabeTextFeld);
        ausgabeTextFeld.setEditable(false);
        ausgabeTextFeld.setBackground(white);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(suchenLoeschenPanel);
        mainPanel.add(ausgabePanel);
        
        
        this.add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String name = tfSuchenName.getText(); 
		String zusatz = tfSuchenZusatz.getText();
		List<String> ausgabeListe = new LinkedList<String>();
	
		if (source == buttonAnwenden) {
			ausgabeTextFeld.setText("");
			System.out.println(suchOptionen.getSelectedIndex());
			
			if (suchOptionen.getSelectedIndex() == 0) {
				ausgabeTextFeld.setText(name + " " + zusatz + " " + telBuch.exactSearch(name, zusatz));
			} else if (suchOptionen.getSelectedIndex() == 1) {
				
				ausgabeListe = telBuch.prefixSearch(name);
				for (String s : ausgabeListe) {
				}
				String ausgabe = "";
				for (String s : ausgabeListe) {
					ausgabe += s + "\n";
					ausgabeTextFeld.setText(ausgabe);
				}
			} else if (suchOptionen.getSelectedIndex() == 2) {
				telBuch.remove(name, zusatz);
			}
		}
    }
}