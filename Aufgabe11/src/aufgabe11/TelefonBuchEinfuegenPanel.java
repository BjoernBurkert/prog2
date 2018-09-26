// O. Bittel
// 10.03.2017

package aufgabe11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

import javax.swing.border.*;

public class TelefonBuchEinfuegenPanel extends JPanel implements ActionListener {

    private TelefonBuch telBuch;
    private JTextField tfEinfuegenName;
    private JTextField tfEinfuegenZusatz;
    private JTextField tfEinfuegenTelNr;
    private JButton buttonEinfuegen;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb) {
        telBuch = tb;
        
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Zusatz"));
		panel1.add(new JLabel("TelefonNummer"));
		
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1)); 
        tfEinfuegenName = new JTextField("", 20);
        panel2.add(tfEinfuegenName);
        tfEinfuegenZusatz = new JTextField("", 20);
        panel2.add(tfEinfuegenZusatz);
        tfEinfuegenTelNr = new JTextField("", 20);
        panel2.add(tfEinfuegenTelNr);

        Border border = BorderFactory.createTitledBorder("Einfuegen");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(border);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.setPreferredSize(new Dimension(650,100));
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        buttonEinfuegen = new JButton("Einfuegen");
        mainPanel.add(buttonEinfuegen);
        buttonEinfuegen.addActionListener(this);
        
        this.add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String name = tfEinfuegenName.getText(); 
		String zusatz = tfEinfuegenZusatz.getText();
		String telNr = tfEinfuegenTelNr.getText();
	
		if (source == buttonEinfuegen) {
			telBuch.insert(name, zusatz, telNr);
			tfEinfuegenName.setText("");
			tfEinfuegenZusatz.setText("");
			tfEinfuegenTelNr.setText("");
		}
    }
}