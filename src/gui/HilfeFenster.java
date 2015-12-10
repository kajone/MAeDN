package gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class HilfeFenster extends JFrame{

	private JTextArea hilfeText;

	public HilfeFenster(String title)
	{
		super(title);
		
		String text = "Hier kommt der Hilfetext hin.\n Ein Zeilenumbruch ist hier auch möglich :D. \n"
				+ "Die Größe des Feldes passt sich dem Text an";
		
		hilfeText = new JTextArea();
		hilfeText.setText(text);
		this.add(hilfeText);
		this.pack();		
	}
}
