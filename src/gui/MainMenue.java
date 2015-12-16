package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class MainMenue extends JFrame implements ActionListener {

	
	private JButton spielStarten;
	private JButton einstellungen;
	private JButton hilfe;
	private JButton beenden;
	
	
	
	public static void main(String[] args) {
		
		MainMenue mainMenue = new MainMenue("Menue");
		mainMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainMenue.setSize(400, 400);
		
		mainMenue.setLayout(null);
		mainMenue.setVisible(true);
	}

	public MainMenue(String titel){
		super(titel);
		
		try{
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./images/MainBackground.jpg")))));
		} catch(IOException e){
			System.out.println("Image can't find");
		}
		this.setResizable(false);
		
		spielStarten = new JButton("Spiel starten");
		spielStarten.setBounds(120, 40, 160, 40);
		spielStarten.addActionListener(this);
		this.add(spielStarten);
		
		einstellungen = new JButton("Einstellungen");
		einstellungen.setBounds(120, 120, 160, 40);
		einstellungen.addActionListener(this);
		this.add(einstellungen);
		
		hilfe = new JButton("Hilfe");
		hilfe.setBounds(120, 200, 160, 40);
		hilfe.addActionListener(this);
		this.add(hilfe);
		
		beenden = new JButton("Beenden");
		beenden.setBounds(120, 280, 160, 40);
		beenden.addActionListener(this);
		this.add(beenden);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spielStarten ){
			SpielLobby lobbyFenster = new SpielLobby("Lobby");
		}
		
		if(e.getSource() == einstellungen ){
			
			Einstellungen einstellungsFenster = new Einstellungen("Einstellungen");
			
		}
		
		if(e.getSource() == hilfe){
		
			HilfeFenster hilfefenster = new HilfeFenster("Hilfe");
			hilfefenster.setLayout(null);
			hilfefenster.setVisible(true);
		}
		
		if(e.getSource() == beenden) {
			System.exit(0);
		}
	}
	
}