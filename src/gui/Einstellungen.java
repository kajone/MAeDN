package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Einstellungen extends JFrame implements ActionListener{
	
	private JLabel spielfeld;
	private JLabel spielerName;
	private JTextField spielerNameEingabe;
	private JButton speichern;

	public Einstellungen(String titel) {
		
		super(titel);

		
		this.setSize(400, 400);
		this.setLayout(null);
		this.setVisible(true);
		
		try{
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./images/EinstellungenBackground.jpg")))));
		} catch(IOException e){
			System.out.println("Image can't find");
		}
		this.setResizable(false);
		
		spielfeld = new JLabel();
		spielfeld.setBounds(40, 40, 100, 100);
		spielfeld.setText("Spielfeld: ");
		spielfeld.setFont(new Font("Arial",Font.BOLD, 18));
		this.add(spielfeld);
		
		spielerName = new JLabel();
		spielerName.setBounds(40, 270, 100, 40);
		spielerName.setText("Name: ");
		spielerName.setFont(new Font("Arial",Font.BOLD, 18));
		this.add(spielerName);
		
		spielerNameEingabe = new JTextField();
		spielerNameEingabe.setBounds(250, 280, 100, 20);
		this.add(spielerNameEingabe);
		
		speichern = new JButton("Speichern");
		speichern.setBounds(150, 320, 100, 20);
		speichern.addActionListener(this);
		this.add(speichern);
		
			 	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == speichern ){
			String spielername = spielerNameEingabe.getText();
			System.out.println(spielername);
			this.dispose();
		}
	}

}
