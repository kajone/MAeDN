package gui;

import java.awt.Container;
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
		
<<<<<<< HEAD
		MainMenue mainMenue = new MainMenue("Men�");
=======
		MainMenue mainMenue = new MainMenue("Menü");
>>>>>>> 7e6a2372173fd027e94920066dfef6857c1dc5ee
		mainMenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		try{
//		mainMenue.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Florian/workspace/MAeDN/MAeDN/images/images.jpg")))));
//		} catch(IOException e){
//			System.out.println("Image can't find");
//		}
//		mainMenue.setResizable(false);
		mainMenue.setSize(400, 400);
		
		mainMenue.setLayout(null);
		mainMenue.setVisible(true);
	}

	public MainMenue(String titel){
		super(titel);
		
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
	
	
	public static void fenster(){
		JFrame fenster = new JFrame();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(650, 350);
		fenster.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == spielStarten ){
			fenster();
		}
		
		if(e.getSource() == einstellungen ){
			Object[] options = { "OK"};
			
			JOptionPane.showOptionDialog(null, "Hier kommen irgendwann mal die Einstellungen hin!!", "Einstellungen", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
		
		if(e.getSource() == hilfe){
			Object[] options = { "OK"};
			
			JOptionPane.showOptionDialog(null, "Hier kommt irgendwann mal die Hilfe hin!!", "Hilfe", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
		
		if(e.getSource() == beenden) {
			System.exit(0);
		}
	}
	
}
