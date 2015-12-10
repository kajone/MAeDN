package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SpielErstellenEinstellungen extends JFrame implements ActionListener{

	JLabel spielerAnzahl;
	JLabel passwort;
	JTextField spielerAnzahlEingabe;
	JTextField passwortEingabe;
	JButton erstellen;
	
	public SpielErstellenEinstellungen(String titel)
	{
		super(titel);
		
		this.setSize(500, 300);
		this.setLayout(null);
		this.setVisible(true);
		
		spielerAnzahl = new JLabel();
		spielerAnzahl.setBounds(20, 50, 200, 40);
		spielerAnzahl.setText("Mindestanzahl Spieler(max. 4)");
		spielerAnzahl.setFont(new Font("Arial",Font.BOLD, 11));
		this.add(spielerAnzahl);
		
		passwort = new JLabel();
		passwort.setBounds(20, 150, 200, 40);
		passwort.setText("Passwort(optional)");
		passwort.setFont(new Font("Arial",Font.BOLD, 11));
		this.add(passwort);
		
		spielerAnzahlEingabe = new JTextField();
		spielerAnzahlEingabe.setBounds(350, 60, 100, 20);
		this.add(spielerAnzahlEingabe);
		
		passwortEingabe = new JTextField();
		passwortEingabe.setBounds(350, 160, 100, 20);
		this.add(passwortEingabe);
		
		erstellen = new JButton("erstellen");
		erstellen.setBounds(200, 230, 100, 20);
		erstellen.addActionListener(this);
		this.add(erstellen);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == erstellen) {
			int minSpieler =  Integer.parseInt(spielerAnzahlEingabe.getText());
			String password = passwortEingabe.getText();
			
			System.out.println(minSpieler + " " + password);
			// TODO Hier muss nun das Spiel aufgerufen werden
			this.dispose();
		}
	}
}
