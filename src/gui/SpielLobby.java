package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import logik.MainClass;
import server.Client;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class SpielLobby extends JFrame implements ActionListener{
	
	private JButton spielBeitreten;
	private JButton aktualisieren;
	private JTextField ipInput;

	public SpielLobby(String titel) {

		super(titel);

		
		this.setSize(600, 600);
		getContentPane().setLayout(null);
		this.setVisible(true);
		
		spielBeitreten = new JButton("Spiel beitreten");
		spielBeitreten.setBounds(10, 240, 160, 40);
		spielBeitreten.addActionListener(this);
		getContentPane().add(spielBeitreten);
		
		aktualisieren = new JButton("aktualiesieren");
		aktualisieren.setBounds(450, 20, 120, 30);
		aktualisieren.addActionListener(this);
		getContentPane().add(aktualisieren);
		
		ipInput = new JTextField();
		ipInput.setBounds(10, 197, 160, 20);
		getContentPane().add(ipInput);
		ipInput.setColumns(10);
		
		JLabel iPLabel = new JLabel("IP:");
		iPLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iPLabel.setBounds(10, 176, 76, 20);
		getContentPane().add(iPLabel);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == spielBeitreten){
			Spielbrett brett = new Spielbrett("Mensch Aergere Dich Nicht", ipInput.getText());	
			
			this.dispose();
		}
	}
}