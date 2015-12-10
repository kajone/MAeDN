package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SpielLobby extends JFrame implements ActionListener{
	
	private JButton spielBeitreten;
	private JButton spielErstellen;
	private JButton aktualisieren;

	public SpielLobby(String titel) {

		super(titel);

		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		
		spielBeitreten = new JButton("Spiel beitreten");
		spielBeitreten.setBounds(10, 240, 160, 40);
		spielBeitreten.addActionListener(this);
		this.add(spielBeitreten);
		
		spielErstellen = new JButton("Spiel erstellen");
		spielErstellen.setBounds(10, 320, 160, 40);
		spielErstellen.addActionListener(this);
		this.add(spielErstellen);
		
		aktualisieren = new JButton("aktualiesieren");
		aktualisieren.setBounds(450, 20, 120, 30);
		aktualisieren.addActionListener(this);
		this.add(aktualisieren);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == spielErstellen ){
			SpielErstellenEinstellungen spielErstellen = new SpielErstellenEinstellungen("Spiel erstllen");
			this.dispose();
		}
	}

}
