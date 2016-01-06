package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Einstellungen extends JFrame implements ActionListener{
	
	private JLabel spielFigur;
	private JLabel spielerName;
	private JTextField spielerNameEingabe;
	private JButton speichern;
	
	private String[] farben = {"gelb", "gruen", "rot", "schwarz"};
	JComboBox<String> farbenAuswahl;
	public static Preferences userPrefs;

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
		
		spielFigur = new JLabel();
		spielFigur.setBounds(40, 40, 100, 100);
		spielFigur.setText("Spielfigur: ");
		spielFigur.setFont(new Font("Arial",Font.BOLD, 18));
		this.add(spielFigur);
		
		farbenAuswahl = new JComboBox<String>(farben);
		farbenAuswahl.setBounds(250, 75, 100, 30);
		this.add(farbenAuswahl);
		
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

		if(e.getSource() == speichern ){
			String spielername = spielerNameEingabe.getText();
			String farbe = (String) farbenAuswahl.getSelectedItem();
			System.out.println(farbe);
			System.out.println(spielername);
			
			Writer fw = null;

			try
			{
			  fw = new FileWriter( "Einstellungen.txt" );
			  fw.write(spielername + "\n" + farbe);
			}
			catch ( IOException e1 ) {
			  System.err.println( "Konnte Einstellungen.txt nicht überschreiben" );
			}
			finally {
			  if ( fw != null )
			    try { fw.close(); } catch ( IOException e1 ) { e1.printStackTrace(); }
			}
			
			this.dispose();
		}
	}
	

}
