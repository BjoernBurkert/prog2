package aufgabe10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.math.*;

import javax.swing.*;


public class TaschenrechnerVorlesung extends JFrame implements ActionListener, ItemListener{
	
	JTextField opx;
	JTextField opy;
	JTextField res;
	
	JButton sumButton;
	JButton multButton;
	JButton subButton;
	JButton divButton;
	JButton sinButton;
	JButton cosButton;
	JButton xayButton;
	JButton log2Button;
	JButton clearButton;
	
	JRadioButton degButton;
	JRadioButton radButton;
	
	JCheckBox HellesDisplay;
	
	public TaschenrechnerVorlesung(){
		setTitle("Taschenrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel opxLabel = new JLabel("Operand X");
		JLabel opyLabel = new JLabel("Operand Y");
		JLabel resLabel = new JLabel("Resultat");
		
		opx = new JTextField("0",10);
		opy = new JTextField("0",10);
		res = new JTextField("0",10);
		res.setEditable(false);
		sumButton = new JButton("+");
		multButton = new JButton("*");
		subButton = new JButton("-");
		divButton = new JButton("/");
		sinButton = new JButton("sin");
		cosButton = new JButton("cos");
		xayButton = new JButton("x^y");
		log2Button = new JButton("log2");
		clearButton = new JButton("Clear");
		
		sumButton.addActionListener(this);
		multButton.addActionListener(this);
		subButton.addActionListener(this);
		divButton.addActionListener(this);
		sinButton.addActionListener(this);
		cosButton.addActionListener(this);
		xayButton.addActionListener(this);
		log2Button.addActionListener(this);
		clearButton.addActionListener(this);
		
		degButton = new JRadioButton("Deg");
		degButton.addActionListener(this);
		degButton.setSelected(true);
		radButton = new JRadioButton("Rad");
		radButton.addActionListener(this);
		HellesDisplay = new JCheckBox("Helles Display");
		HellesDisplay.addItemListener(this);
		HellesDisplay.setSelected(true);		
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(degButton);
		group.add(radButton);
		degButton.addActionListener(this);
		radButton.addActionListener(this);
		
		JPanel radioPanel = new JPanel();
		radioPanel.add(degButton);
		radioPanel.add(radButton);
		radioPanel.add(HellesDisplay);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(opxLabel);
		panel1.add(opx);
		panel1.add(opyLabel);
		panel1.add(opy);
		panel1.add(resLabel);
		panel1.add(res);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 4));
		panel2.add(sumButton);
		panel2.add(multButton);
		panel2.add(subButton);
		panel2.add(divButton);
		panel2.add(sinButton);
		panel2.add(cosButton);
		panel2.add(xayButton);
		panel2.add(log2Button);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 1));
		panel3.add(clearButton);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(panel1);
		panel.add(radioPanel);
		panel.add(panel2);
		panel.add(panel3);
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		setContentPane(panel);
		
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		String s1 = opx.getText();
		String s2 = opy.getText();
		double o1 = Double.parseDouble(s1);
		double o2 = Double.parseDouble(s2);
		if(source == sumButton){
			res.setText(String.format(Locale.US, "%.2f", o1+o2));
		}
		else if(source == multButton){
			res.setText(String.format(Locale.US, "%.2f", o1*o2));
		}
		else if(source == subButton){
			res.setText(String.format(Locale.US, "%.2f", o1-o2));
		}
		else if(source == divButton){
			res.setText(String.format(Locale.US, "%.2f", o1/o2));
		}
		else if(source == xayButton){
			res.setText("" + (Math.pow(o1, o2)));
		}
		else if(source == log2Button){
			res.setText("" + (Math.log(o1)));
		}
		else if(source == sinButton){
			if(degButton.isSelected()){
				o1 = Math.toRadians(o1);
			} 
			res.setText("" + (Math.sin(o1)));
		}
		else if(source == cosButton){
			if(degButton.isSelected()){
				o1 = Math.toRadians(o1);
			} 
			res.setText("" + (Math.cos(o1)));
		}
		else if(source == clearButton){
			opx.setText("0");
			opy.setText("0");
			res.setText("0");
		}
	}
	

	public static void main(String[] args) {
		JFrame meinTaschenrechner = new TaschenrechnerVorlesung();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		
		if(e.getStateChange() == ItemEvent.DESELECTED){
			
			opx.setBackground(Color.WHITE);
			opy.setBackground(Color.WHITE);
			res.setBackground(Color.WHITE);
			opx.setForeground(Color.BLACK);
			opy.setForeground(Color.BLACK);
			res.setForeground(Color.BLACK);
		}
		else {
			opx.setBackground(Color.BLACK);
			opy.setBackground(Color.BLACK);
			res.setBackground(Color.BLACK);
			opx.setForeground(Color.YELLOW);
			opy.setForeground(Color.YELLOW);
			res.setForeground(Color.YELLOW);
		}
	}
	
		
	}

