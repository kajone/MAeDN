package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class HilfeFenster extends JFrame{

	private JTextArea hilfeText;
	private JPanel panel;
	JTextArea textfeld;
	JScrollPane scrollpane;

	public HilfeFenster(String title)
	{
		super(title);
		
		this.setSize(300, 150);
		panel = new JPanel();
		textfeld = new JTextArea(25,40);
		
		String text = "Hier kommt der Hilfetext hin.\n Ein Zeilenumbruch ist hier auch möglich :D. \n"
				+ "Die Größe des Feldes passt sich dem Text an. Die Größe des Feldes passt sich dem Text an. Die Größe des Feldes passt sich dem Text an. ";
				
		textfeld.setText(text);
		textfeld.setLineWrap(true);
		textfeld.setWrapStyleWord(true);
		textfeld.setEditable(false);
		
		scrollpane = new JScrollPane(textfeld);
		
		panel.add(scrollpane);
		
		this.add(panel);
		this.setVisible(true);
		this.pack();
	}
}
